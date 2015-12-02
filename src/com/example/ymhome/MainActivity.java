package com.example.ymhome;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.example.ymhome.fragment.ForthPageFragment;
import com.example.ymhome.fragment.MainPageFragment;
import com.example.ymhome.fragment.SecondPageFragment;
import com.example.ymhome.fragment.ThirdPageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener {

	private List<Fragment> mFragments = new ArrayList<Fragment>();
	private List<RadioButton> mTabs = new ArrayList<RadioButton>();
	private FragmentManager fragmentManager;
	private int checkNum = 0;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		bindEvent();
		mTabs.get(0).setChecked(true);
	}



	private void initView() {
		fragmentManager = getFragmentManager();
		mFragments.add(new MainPageFragment());
		mFragments.add(new SecondPageFragment());
		mFragments.add(new ThirdPageFragment());
		mFragments.add(new ForthPageFragment());
		mTabs.add((RadioButton) findViewById(R.id.rb_tab1));
		mTabs.add((RadioButton) findViewById(R.id.rb_tab2));
		mTabs.add((RadioButton) findViewById(R.id.rb_tab3));
		mTabs.add((RadioButton) findViewById(R.id.rb_tab4));

		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.main_content, mFragments.get(0));
		for (int i = 1; i<mFragments.size();i++){
			transaction.add(R.id.main_content,mFragments.get(i));
			transaction.hide(mFragments.get(i));
		}
		transaction.commit();
	}

	private void bindEvent() {
		for (int i = 0;i<mTabs.size();i++){
			mTabs.get(i).setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View view) {
		int tempCheck = -1;
		switch (view.getId()){
			case R.id.rb_tab1:
				tempCheck = 0;
				break;
			case R.id.rb_tab2:
				tempCheck = 1;
				break;
			case R.id.rb_tab3:
				tempCheck = 2;
				break;
			case R.id.rb_tab4:
				tempCheck = 3;
				break;
		}
		if (tempCheck == checkNum){
			return;
		}
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.hide(mFragments.get(checkNum));
		transaction.show(mFragments.get(tempCheck));
		transaction.commit();
		checkNum = tempCheck;
	}
}
