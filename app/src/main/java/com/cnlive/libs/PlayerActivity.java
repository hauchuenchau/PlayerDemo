package com.cnlive.libs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.cnlive.R;
import com.cnlive.libs.video.video.base.ISltDataSource;
import com.cnlive.libs.video.video.base.ISltVideoView;
import com.cnlive.libs.view.MyMediaPlayer;

/**
 * 视连通播放视频
 */
public class PlayerActivity extends AppCompatActivity implements ISltVideoView.OnSltVideoEventListener{
    private static final String TAG = "PlayerActivity";
    private MyMediaPlayer cnVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_player);
        //初始化
        initPlayer();
    }

    private void initPlayer() {
        cnVideoPlayer = (MyMediaPlayer) findViewById(R.id.mn_videoplayer);
        //播放视连通视频资源
        cnVideoPlayer.setDataSource(new ISltDataSource() {
            @Override
            public int getDataSourceId() {
                return 321;
            }
        }, "@TV");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        PlayerActivity.this.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cnVideoPlayer.pauseVideo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cnVideoPlayer.startVideo();
    }

    @Override
    protected void onDestroy() {
        //一定要记得销毁View
        if (cnVideoPlayer != null) {
            cnVideoPlayer.destroyVideo();
            cnVideoPlayer = null;
        }
        super.onDestroy();
    }

    @Override
    public void onClickProgressbarObjectLink(int mediaId) {
        //模板上物体详情链接被点击
        Log.e("DemoView","连接");
    }

    @Override
    public void onClickProgressbarObject(int mediaId) {
        //进度条上的物体被点击展示模板
        Log.e("DemoView","显示广告");
    }
}
