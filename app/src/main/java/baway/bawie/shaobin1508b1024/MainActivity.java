package baway.bawie.shaobin1508b1024;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;

import baway.bawie.shaobin1508b1024.net.OkHttpUtils;
import baway.bawie.shaobin1508b1024.net.OnNetListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        String url = "http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=20&gender=2&ts=1871746850&page=1";
        OkHttpUtils.getInstance(MainActivity.this).doget(url, UserBean.class, new OnNetListener() {
            @Override
            public void onSuccess(Object o) throws IOException {
                UserBean bean = (UserBean) o;
                RvAdapter adapter = new RvAdapter(MainActivity.this, bean.getData());
                mRv.setAdapter(adapter);
            }

            @Override
            public void onError(IOException e) {

            }
        });
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}
