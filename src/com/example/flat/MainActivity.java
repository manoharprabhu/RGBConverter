package com.example.flat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void convertToHex(View view) {
	
		int red=0,green=0,blue=0;

		if(((EditText)findViewById(R.id.redR)).getText().toString().trim().equals("") == false)
		 red = Integer.parseInt(((EditText)findViewById(R.id.redR)).getText().toString());
		else {
			((EditText)findViewById(R.id.redR)).setText("00");
		}
		
		if(((EditText)findViewById(R.id.greenG)).getText().toString().trim().equals("") == false)
		green = Integer.parseInt(((EditText)findViewById(R.id.greenG)).getText().toString());
		else {
			((EditText)findViewById(R.id.greenG)).setText("00");
		}
		
		if(((EditText)findViewById(R.id.blueB)).getText().toString().trim().equals("") == false)
		blue = Integer.parseInt(((EditText)findViewById(R.id.blueB)).getText().toString());
		else {
			((EditText)findViewById(R.id.blueB)).setText("00");
		}
		
		if(red > 255)
		{
			red = 255;
			((EditText)findViewById(R.id.redR)).setText("255");
		}
		
		if(blue > 255){
			blue = 255;
			((EditText)findViewById(R.id.blueB)).setText("255");
		}
		
		if(green > 255){
			green = 255;
			((EditText)findViewById(R.id.greenG)).setText("255");
		}
		
		TextView hexValueTextView = (TextView)findViewById(R.id.hexValue);
		
		hexValueTextView.setText("#" + getHexValue(red) + getHexValue(green) + getHexValue(blue));
		hexValueTextView.setTextColor(Color.rgb(red, green, blue));
	}
	
	public String getHexValue(int value){
		String hexCode = "";
		if(value == 0)
			return "00";
		ArrayList<String> codesArrayList = new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"));
	//	String hexCode = "";
		while(value != 0){
			int remainder = value % 16;
			value = value / 16;
			hexCode = hexCode + codesArrayList.get(remainder);
		}
		if(hexCode.length() == 1) {
			return("0" + hexCode);
		}
		System.out.println(hexCode);
		return reverseString(hexCode);
	}
	
	
	public String reverseString(String code){
		String reverseStringCode = "";
		for(Character character: code.toCharArray()){
			reverseStringCode = character + reverseStringCode;
		}
		return reverseStringCode;
	}

}
