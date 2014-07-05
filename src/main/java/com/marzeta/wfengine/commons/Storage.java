package com.marzeta.wfengine.commons;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.marzeta.wfengine.model.common.EntityCommon;

public class Storage {
	public EntityCommon readFile(String filename) {
		FileInputStream os = null;
		try {
			os = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XMLDecoder decoder = new XMLDecoder(os);
		EntityCommon object = (EntityCommon) decoder.readObject();
		decoder.close();
		return object;
	}

	public String saveObjectToFile(EntityCommon object) {
//		System.out.println("Saving workflow " + object);
		String filename = object.toString() + ".xml";
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			XMLEncoder encoder = new XMLEncoder(fout);
			encoder.writeObject(object);
			encoder.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}
}
