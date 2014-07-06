/**
 * 
 */
package cn.newcapec.function.citycard.platform.ocean;

/**
 * @author ocean
 * email: zhangjunfang0505@163.com
 * QQ: 419692181
 * date: 2014-2-24
 */
public class FF {

	public void  getF(int... is){
		
		for(int i:is){
			System.out.println(i);
		}
		
	}
	public static void main(String[] args) {
		//xx.(type);
		new FF().getF(new int[]{1,2,3,4,5,6,7,8,9,0});

	}

}
