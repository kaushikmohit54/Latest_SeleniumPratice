package org.imagenecsi.initiators;

import static com.olo.util.PropertyReader.configProp;

import com.olo.initiator.InitiatorUtil;

public class ImageneCsiConfiguration extends InitiatorUtil{
	
	public static final String imageCsiurl = configProp.getProperty("ImageneCsiUSer");
	
}
