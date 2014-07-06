package com.rop.sample.request;

import java.util.Collection;

import com.rop.request.RopConverter;

@SuppressWarnings("rawtypes")
public class CollectionsConverter implements RopConverter<String, Collection> {

    @Override
    public String unconvert(Collection target) {
        return null;
    }

    @Override
    public Class<String> getSourceClass() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Class<Collection> getTargetClass() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection convert(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
