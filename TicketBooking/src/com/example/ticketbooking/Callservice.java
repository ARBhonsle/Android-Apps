package com.example.ticketbooking;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

public class Callservice {
	private static String NAMESPACE="http://New/";
	private static String URL="http://localhost:8080/WebApp1/NewWebService?WSDLcmd";
//192.168.42.73
	public static String registerService(String s1, String s2, String s3,
		String s4, String method) {
		// TODO Auto-generated method stub
		String restex=null;
		SoapObject soap=new SoapObject(NAMESPACE, method);
		soap.addProperty("username", s1);
		soap.addProperty("password", s2);
		soap.addProperty("email", s3);
		soap.addProperty("phonenumber", s4);
		SoapSerializationEnvelope env=new SoapSerializationEnvelope(SoapEnvelope.VER11);
		env.setOutputSoapObject(soap);
		HttpTransportSE http=new HttpTransportSE(URL);
		try {
			http.call(NAMESPACE+method, env);
			SoapPrimitive primitive =(SoapPrimitive) env.getResponse();
			restex=primitive.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		} catch (XmlPullParserException e) {
			e.printStackTrace();
			return "error";	
		}
		
		return restex;
	}

}
