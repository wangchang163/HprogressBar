自定义进度条样式

可以修改进度色，背景色，文本色以及文本大小等
![images](https://github.com/wangchang163/HprogressBar/blob/master/images/device-2017-07-31-153356.png)

使用


Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2. Add the dependency

    dependencies {
	        compile 'com.github.wangchang163:HprogressBar:v1.0'
	}
	
Step 3. XML

    <com.example.testing.library.HprogressView
          android:id="@+id/hProgressView"
          android:layout_width="match_parent"
          android:layout_height="12dp"
          app:bg_color="@color/colorPrimary"
          app:pro_color="@color/colorAccent"
          app:txt_color="#FFFFFF"
          android:layout_gravity="center"
          android:layout_margin="12dp"
          />


Step 4. Java

示例：

        hProgressView= (HprogressView) findViewById(R.id.hProgressView);
        hProgressView.startAnim();
        
        
真实运用：

        hProgressView= (HprogressView) findViewById(R.id.hProgressView);
//        hProgressView.startAnim();

        final Handler handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                switch (message.what){
                    case 1:
                        hProgressView.setProgress(message.arg1);
                        break;
                }
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<101;i++){
                    Message message=new Message();
                    message.what=1;
                    message.arg1=i;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        
调用setProgress（）接口，传入进度值即可