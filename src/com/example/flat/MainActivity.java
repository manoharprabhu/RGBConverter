package com.example.flat;

import java.util.ArrayList;
import java.util.Arrays;

import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setListeners();
		drawCustomThumb();
	
	}
	
	public void drawCustomThumb() {
		ShapeDrawable redThumb = new ShapeDrawable(new RectShape());
		redThumb.getPaint().setColor(Color.rgb(255, 0, 0));
		redThumb.setIntrinsicHeight(60);
		redThumb.setIntrinsicWidth(5);
	    
	    ShapeDrawable greenThumb = new ShapeDrawable(new RectShape());
	    greenThumb.getPaint().setColor(Color.rgb(0, 255, 0));
	    greenThumb.setIntrinsicHeight(60);
	    greenThumb.setIntrinsicWidth(5);
	    
	    ShapeDrawable blueThumb = new ShapeDrawable(new RectShape());
	    blueThumb.getPaint().setColor(Color.rgb(0, 0, 255));
	    blueThumb.setIntrinsicHeight(60);
	    blueThumb.setIntrinsicWidth(5);
	    
	    ((SeekBar)findViewById(R.id.redSeekBar)).setThumb(redThumb);
	    ((SeekBar)findViewById(R.id.greenSeekBar)).setThumb(greenThumb);
	    ((SeekBar)findViewById(R.id.blueSeekBar)).setThumb(blueThumb);
	}
	
	public void setListeners(){
		
		((SeekBar)findViewById(R.id.redSeekBar)).setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				((EditText)findViewById(R.id.redR)).setText(String.valueOf(arg0.getProgress()));
				convertHelper();
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		((SeekBar)findViewById(R.id.greenSeekBar)).setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				((EditText)findViewById(R.id.greenG)).setText(String.valueOf(arg0.getProgress()));
				convertHelper();
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		((SeekBar)findViewById(R.id.blueSeekBar)).setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
	
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				((EditText)findViewById(R.id.blueB)).setText(String.valueOf(arg0.getProgress()));
				convertHelper();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			
		});
	
		((EditText)findViewById(R.id.redR)).setSelectAllOnFocus(true);
		((EditText)findViewById(R.id.greenG)).setSelectAllOnFocus(true);
		((EditText)findViewById(R.id.blueB)).setSelectAllOnFocus(true);
		
		
		
		((EditText)findViewById(R.id.redR)).addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable redbox) {
				if(redbox.toString().equals("")){
					redbox.append('0');
				}
				((SeekBar)findViewById(R.id.redSeekBar)).setProgress(Integer.parseInt(redbox.toString()));
			((EditText)findViewById(R.id.redR)).setSelection(((EditText)findViewById(R.id.redR)).length());
			convertHelper();
			}
		});
		
((EditText)findViewById(R.id.greenG)).addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable greenbox) {
				if(greenbox.toString().equals("")){
					greenbox.append('0');
				}
				((SeekBar)findViewById(R.id.greenSeekBar)).setProgress(Integer.parseInt(greenbox.toString()));
			((EditText)findViewById(R.id.greenG)).setSelection(((EditText)findViewById(R.id.greenG)).length());
			convertHelper();
			}
		});


((EditText)findViewById(R.id.blueB)).addTextChangedListener(new TextWatcher() {
	
	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterTextChanged(Editable bluebox) {
		if(bluebox.toString().equals("")){
			bluebox.append('0');
		}
		((SeekBar)findViewById(R.id.blueSeekBar)).setProgress(Integer.parseInt(bluebox.toString()));
	((EditText)findViewById(R.id.blueB)).setSelection(((EditText)findViewById(R.id.blueB)).length());
	convertHelper();
	}
});


	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void convertHelper(){
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
		
		if(red < 0)
		{
			red = 0;
			((EditText)findViewById(R.id.redR)).setText("0");
		}
		
		if(blue < 0){
			blue = 0;
			((EditText)findViewById(R.id.blueB)).setText("0");
		}
		
		if(green < 0){
			green = 0;
			((EditText)findViewById(R.id.greenG)).setText("0");
		}
		
		TextView hexValueTextView = (TextView)findViewById(R.id.hexValue);
		
		hexValueTextView.setText("#" + getHexValue(red) + getHexValue(green) + getHexValue(blue));
		((TextView)findViewById(R.id.colorIndicator)).setBackgroundColor(Color.rgb(red, green, blue));
		hexValueTextView.setTextColor(Color.rgb(0, 0, 0));
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
	
	public void changeByte(View view){
	
		Button clickedButton = (Button)view;
		
		convertHelper();
		
		if(clickedButton.getId() == R.id.firstByteIncrease) {
			int value = Integer.parseInt(((EditText)findViewById(R.id.redR)).getText().toString());
			((EditText)findViewById(R.id.redR)).setText(String.valueOf(value + 1));
		} else if(clickedButton.getId() == R.id.firstByteDecrease) {
			int value = Integer.parseInt(((EditText)findViewById(R.id.redR)).getText().toString());
			((EditText)findViewById(R.id.redR)).setText(String.valueOf(value - 1));
		} else if(clickedButton.getId() == R.id.secondByteIncrease) {
			int value = Integer.parseInt(((EditText)findViewById(R.id.greenG)).getText().toString());
			((EditText)findViewById(R.id.greenG)).setText(String.valueOf(value + 1));
		} else if(clickedButton.getId() == R.id.secondByteDecrease) {
			int value = Integer.parseInt(((EditText)findViewById(R.id.greenG)).getText().toString());
			((EditText)findViewById(R.id.greenG)).setText(String.valueOf(value - 1));
		} else if(clickedButton.getId() == R.id.thirdByteIncrease) {
			int value = Integer.parseInt(((EditText)findViewById(R.id.blueB)).getText().toString());
			((EditText)findViewById(R.id.blueB)).setText(String.valueOf(value + 1));
		} else if(clickedButton.getId() == R.id.thirdByteDecrease) {
			int value = Integer.parseInt(((EditText)findViewById(R.id.blueB)).getText().toString());
			((EditText)findViewById(R.id.blueB)).setText(String.valueOf(value - 1));
		}
		
	}
}
