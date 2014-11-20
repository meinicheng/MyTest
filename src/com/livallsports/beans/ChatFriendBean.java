package com.livallsports.beans;

import java.io.Serializable;

public class ChatFriendBean implements Serializable{
	
	private String mSessionID;
	private String mUserID;
	private String mFriendID;
	private String mFriendHead;
	private String mFriendName;
	
	public ChatFriendBean(String mSessionID, String mUserID, String mFriendID,
			String mFriendHead, String mFriendName) {
		super();
		this.mSessionID = mSessionID;
		this.mUserID = mUserID;
		this.mFriendID = mFriendID;
		this.mFriendHead = mFriendHead;
		this.mFriendName = mFriendName;
	}
	
	public ChatFriendBean() {
		
	}
	
	public void parseDBFriendBean(DBFriendBean friendBean) {
		this.mSessionID = friendBean.getmSessionID();
		this.mFriendHead = friendBean.getmFriendHead();
		this.mFriendID = friendBean.getmFriendID();
		this.mFriendName = friendBean.getmFriendName();
		this.mUserID = friendBean.getmUserID();
	}

	public String getmSessionID() {
		return mSessionID;
	}

	public void setmSessionID(String mSessionID) {
		this.mSessionID = mSessionID;
	}

	public String getmUserID() {
		return mUserID;
	}

	public void setmUserID(String mUserID) {
		this.mUserID = mUserID;
	}

	public String getmFriendID() {
		return mFriendID;
	}

	public void setmFriendID(String mFriendID) {
		this.mFriendID = mFriendID;
	}

	public String getmFriendHead() {
		return mFriendHead;
	}

	public void setmFriendHead(String mFriendHead) {
		this.mFriendHead = mFriendHead;
	}

	public String getmFriendName() {
		return mFriendName;
	}

	public void setmFriendName(String mFriendName) {
		this.mFriendName = mFriendName;
	}
}
