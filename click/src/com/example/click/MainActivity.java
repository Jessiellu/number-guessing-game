package com.example.click;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button bstart,bclick;
	TextView t1,t2;
	EditText n;
	boolean flag=false;
	int num,result;
	int min=1,max=100;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bstart=(Button)findViewById(R.id.start);
        bclick=(Button)findViewById(R.id.click);
        t1=(TextView)findViewById(R.id.tv);
        t2=(TextView)findViewById(R.id.te);
        n=(EditText)findViewById(R.id.input);
        /*
        bstart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(flag==false){
					bstart.setText("结束游戏");
					t.setText("输入一个整数，范围在1——100");
					flag=true;
				}else{
					bstart.setText("开始游戏");
					flag=false;
				}
			}
		});
        
        bclick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
        bstart.setOnClickListener(game);
        bclick.setOnClickListener(game);
        
    }

    OnClickListener game = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId()==R.id.start){
				if(bstart.getText().toString().equals("开始游戏")){
					flag=true;
					t1.setText("输入一个整数，范围在1——100");
					result=(int)(Math.random()*100)+1;
					n.setEnabled(true);
					bstart.setText("结束游戏");
				}
				else if(bstart.getText().toString().equals("结束游戏")){
					flag=false;
					t1.setText("");
					n.setText("");
					n.setEnabled(false);
					bstart.setText("开始游戏");
					t2.setText("");
					min=1;
					max=100;
				}
			}else if(v.getId()==R.id.click){
				if(n.getText().toString().equals("")){
					Toast tt = Toast.makeText(MainActivity.this, "请先输入数字", Toast.LENGTH_LONG);
				}else {
					num=Integer.parseInt(n.getText().toString());
					//Float.parseFloat(string);
					//Double.parseDouble(string);
					if(num>result) {
						max=num;
						//t1.setText("输入一个整数，范围在"+min+"——"+max);
					}
					else if(num<result) {
						min=num;
						//t1.setText("输入一个整数，范围在"+min+"——"+max);
					}
					t1.setText("输入一个整数，范围在"+min+"——"+max);
					 if(num==result) {
						t2.setText("BINGO!答对了!\n游戏结束!");
						//bstart.setText("开始游戏");
						flag=false;
						n.setEnabled(false);
					}
				
				}
			}
		}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
