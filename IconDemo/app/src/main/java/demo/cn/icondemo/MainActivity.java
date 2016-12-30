package demo.cn.icondemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity {
    //头像文件
    private static final String IMAGE_FILE_NAME ="head.jpg";
    //请求识别码
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;

    //截图后图片的宽高正方形

    private static int output_X = 480;
    private static int output_Y = 480;

    private ImageView imageView=null;
    TextView location,cream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageview);
        location= (TextView) findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
        
        cream= (TextView) findViewById(R.id.cream);
        cream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCream();
            }
        });

    }
    /**
     * 从本地获取头像
     * */
    private void getLocation() {
        Intent intentFromLocation = new Intent();
        //设置为减类型
        intentFromLocation.setType("image/*");
        intentFromLocation.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentFromLocation,CODE_GALLERY_REQUEST);
    }

    /**
     * 启动手机拍照作为哦头像
     * */

    private void getCream() {
        Intent intentFromCream = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //判断存储卡是否可用
        if (hasScard()){
            intentFromCream.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                    Environment.getExternalStorageDirectory(),IMAGE_FILE_NAME)));
        }
        startActivityForResult(intentFromCream,CODE_GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_CANCELED){
            Toast.makeText(getApplication(),"取消",Toast.LENGTH_SHORT).show();
            return;
        }
        switch (requestCode){
            case CODE_GALLERY_REQUEST:
                cropRawPhoto(data.getData());
                break;
            case CODE_CAMERA_REQUEST:
                if (hasScard()){
                    File tempFile = new File(
                            Environment.getExternalStorageDirectory(),
                            IMAGE_FILE_NAME);
                    cropRawPhoto(Uri.fromFile(tempFile));
                }else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG)
                            .show();
                }
                break;
            case CODE_RESULT_REQUEST:
                if (data!=null){
                    setImageToHeadView(data);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    //剪切原始图片
    private void cropRawPhoto(Uri uri) {
        Intent intent=new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri,"image/*");

        //设置剪切
        intent.putExtra("crop","true");

        //设置宽高比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);

        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }

    private void setImageToHeadView(Intent intent) {

        Bundle extras = intent.getExtras();
        if (extras !=null ){
            Bitmap bitmap = extras.getParcelable("data");
            imageView.setImageBitmap(bitmap);
        }
    }

    private boolean hasScard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }else {
            return false;
        }
    }
}
