package com.livallsports.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;




import com.livallsports.R;
import com.livallsports.beans.ChatFriendBean;
import com.livallsports.widget.SimpleRoundImageView;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GroupInfoActivity extends Activity {
	private RelativeLayout mrlGroupName;
	private ImageView mImageBack;
	private LinearLayout mllDelete;
	private EditText mEditName;
	private LinearLayout mllRootView;
	private LinearLayout mllGroupHead;
	private String mGroupName;
	private List<ChatFriendBean> mFriendList = new ArrayList<ChatFriendBean>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		setContentView(R.layout.activity_chat_group_info);

		initUI();
		initData();
		initLinstener();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		mllGroupHead = (LinearLayout) findViewById(R.id.ll_chat_group_info_member_list);
		mrlGroupName = (RelativeLayout) findViewById(R.id.rl_chat_group_info_name);
		mEditName = (EditText) findViewById(R.id.edit_chat_group_info_name);
		mllDelete = (LinearLayout) findViewById(R.id.ll_chat_group_info_delete);
		mImageBack = (ImageView) findViewById(R.id.img_chat_group_info_back);
		mllRootView = (LinearLayout) findViewById(R.id.ll_chat_group_info_root_view);
	}

	// 测试数据
	private void getGroupMember() {
		for (int i = 0; i < 17; i++) {
			ChatFriendBean member = new ChatFriendBean();
			mFriendList.add(member);
		}
	}

	private void initData() {
		// TODO Auto-generated method stub
		getGroupMember();
		mEditName.clearFocus();
		mEditName.setText("Hell World!");

		int length = mFriendList.size();
//		int result = length % 4;
		int row = 4;
//		int line = (result == 0 ? length / 4 +1 : length / 4 + 2);
		int line = length / 4 +1 ;
		for (int i = 0; i < line; i++) {
			LayoutInflater inflater = LayoutInflater.from(this);
			LinearLayout linear = new LinearLayout(this);
			linear.setWeightSum(4);
			linear.setPadding(0, 5, 0, 5);
			for (int j = 0; j < row; j++) {
				LinearLayout linearImage = new LinearLayout(this);
				linearImage.setBottom(10);
				linearImage.setTop(10);
				linearImage
						.setLayoutParams(new LinearLayout.LayoutParams(
								LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT, 1));
				linearImage.setGravity(Gravity.CENTER);
		
				SimpleRoundImageView image=new SimpleRoundImageView(this);
				linearImage.addView(image);
				linearImage.setPadding(0, 5, 0, 5);
				LayoutParams p = image.getLayoutParams();
			
				p.height = 150;
				p.width = 150;
				image.setLayoutParams(p);
				if (i * row + j  == length) {
					// 判断是否放 “添加” 图片
					image.setBackgroundResource(R.drawable.common_add_button);
					image.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub

							Toast.makeText(GroupInfoActivity.this, "跳",
									Toast.LENGTH_SHORT).show();
						}
					});
				} else if (i * row + j + 1 > length) {
					
				} else {
					// 这里放member图片
					
					image.setImageResource(R.drawable.renma);

				}

				linear.addView(linearImage);
			}
		
			mllGroupHead.addView(linear);

		}
	}

	private void initLinstener() {
		// TODO Auto-generated method stub
		mImageBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		mllDelete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(GroupInfoActivity.this, "删除", Toast.LENGTH_SHORT)
						.show();
				finish();
			}
		});


	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		String name = mEditName.getText().toString();
		// 这里执行保存群主名字操作…………

		super.onDestroy();
	}

}
