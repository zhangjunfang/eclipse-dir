package com.googlecode.common.remote.pool.resource.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.googlecode.common.remote.pool.impl.GenericObjectPoolImpl;

@Path("/file")
public class UploadFileService {

	private final static Logger LOG=Logger.getLogger(UploadFileService.class);
    private final String UPLOADED_FILE_PATH = UploadFileService.class.getClassLoader().getResource("").getPath();

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    public Response uploadFile(@MultipartForm FileUploadForm form) {
        String fileName = form.getFileName() == null ? "Unknown" : form.getFileName();

        LOG.info("Default Store Root Path: "+UPLOADED_FILE_PATH);
        LOG.info(fileName);

        String splits[] = fileName.split(Pattern.quote("."));

        LOG.info(Arrays.toString(splits));

        StringBuffer completeFilePath = new StringBuffer(UPLOADED_FILE_PATH);
        for (int i = 0; i < splits.length - 2; i++) {
            completeFilePath.append(splits[i]);
            completeFilePath.append("/");
        }
        completeFilePath.append(splits[splits.length - 2]);
        completeFilePath.append(".");
        completeFilePath.append(splits[splits.length - 1]);

        LOG.info(completeFilePath);

        try {
            // Save the file
            File file = new File(completeFilePath.toString());

            String parent = file.getParent();
            if (parent != null) {
                File parentFolder = new File(parent);
                if (!parentFolder.exists())
                    parentFolder.mkdirs();
            }

            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(form.getFileData());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity("[FAIL]: Target Path: " + completeFilePath).build();
        }
        // Build a response to return
        return Response
                .status(200)
                .entity("[SUCCESS]: Target Path: " + completeFilePath).build();
    }


	@GET
	@Path("/getFactory")
	public Response getFactory() {
		String factory = GenericObjectPoolImpl.getClassForResourceFactory();
		return Response.ok(factory, MediaType.TEXT_PLAIN_TYPE).build();
	}

    @POST
    @Path("/setFactory")
    public Response setFactory(@Form FactorySettingForm form) {
        LOG.info(form.getFileName());
        String newResourceFactory = form.getFileName() == null ? "Unknown" : form.getFileName().trim();
        URL resource = UploadFileService.class.getClassLoader().getResource("config.txt");
        File file = new File(resource.getPath());
        file.deleteOnExit();

        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(newResourceFactory.getBytes());
            fos.flush();
            fos.close();

            GenericObjectPoolImpl.resetPoolImpl(newResourceFactory);
        } catch (IOException e) {
            return Response.status(500).entity("[FAIL]: " + e.getMessage()).build();
        }
        // Build a response to return
        return Response.status(200).entity("[SUCCESS]: setFactory is called, new resourceFactory implement class : " + newResourceFactory).build();
    }

}
