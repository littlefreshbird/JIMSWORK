package com.jims.work.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.jims.work.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Listitem_details_activity_fragment extends Fragment {
	  private String[] name = { "china", "world", "hello", "athlete","1","2","3","4","5" };  
	  
	    private String[] desc = { "中国中国中国中国中国中国中国", "百家执行百家执行百家执行百家执行百家执行百家执行", "慰问慰问慰问慰问"
	    		+ "慰问慰问慰问慰问慰问慰问慰问慰问", "运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动运动","奥运奥运奥"
	    				+ "运奥运奥运","12345645","1234654865416","1314546514658","13246548565"};  
	  
	    private int[] imageids = { R.drawable.menu1, R.drawable.menu2,
	            R.drawable.menu3, R.drawable.menu1 ,R.drawable.menu1,R.drawable.menu1,R.drawable.menu1,R.drawable.menu1,R.drawable.menu1};  
	    
//回复数据	        
		private String[] replyname={"张医生", "李医生", "陆医生", "刘医生" };
	    
		private String[] replydesc = { "你好，可以口服维生素C，它对美白有非常好老的效果的，同时外用天然的维生素E进行涂抹，每次在洗脸之后涂抹在脸上按摩5-10分钟，每天两次，坚持一段时间对疤痕恢复会有非常好的效果的", "病情分析: 如果只是表皮的损伤，及时清创，注意不要感染，一般是不留疤的。", "病情分析: 你好，小孩的修复能力还是很强的，只要不伤及真皮层一般不会留疤，就是伤口不是很深，只要注意局"
				+ "部卫生防止感染即可，药店也有擦伤的药膏卖，你可以去问问。", "问题分析:饮食中不要吃酱油，不然好了那块就是黑色的。擦伤后半年内会有色素沉着，"
						+ "一般可以自行消退的，这半年内尽量少晒太阳，恢复会快。意见建议:去完美专卖店或者美容院买芦荟胶 消炎效果最好 没有副作用 还不会留疤","病情分析: 你的情况属于伤口感染，这种情况做好伤口的清创，然后进行抗炎治疗"};  
		  private String[] timedetails = {"2016-07-29","2016-05-23","2016-05-05","2015-12-18"};
		  private String[] clientdetails ={"来自于:华为","来自于:华为","来自于:华为","来自于:华为"};
		 private int[] replyimageids = { R.drawable.menu1, R.drawable.menu2,  
		            R.drawable.menu3, R.drawable.menu1 ,R.drawable.menu1,R.drawable.menu1,R.drawable.menu1,R.drawable.menu1,R.drawable.menu1}; 

		 private int[]  sexmaleitem={R.drawable.male,R.drawable.female,R.drawable.female,R.drawable.female};
		  // ListView lvinfo;
		   ListView  lvinfodetals;
		   ImageView tweet_listitem_userfacetop;
		   TextView  tweet_listitem_usernametop,tweetcontenttop,tweet_listitem_usernametoptime,tweetcontenttclient;
		   
		 List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>(); 
		    List<Map<String, Object>> listItemsdetails = new ArrayList<Map<String, Object>>(); 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view=LayoutInflater.from(getActivity()).inflate(R.layout.activity_item_details, null);
		tweet_listitem_userfacetop=(ImageView)view.findViewById(R.id.tweet_listitem_userfacetop);
		tweet_listitem_usernametop=(TextView)view.findViewById(R.id.tweet_listitem_usernametop);
		tweet_listitem_usernametoptime=(TextView)view.findViewById(R.id.tweet_listitem_usernametoptime);
		tweetcontenttclient=(TextView)view.findViewById(R.id.tweetcontenttclient);
		tweetcontenttop=(TextView)view.findViewById(R.id.tweetcontenttop);
		tweet_listitem_userfacetop.setImageResource( R.drawable.menu1);
		tweet_listitem_usernametop.setText("china");
		tweetcontenttop.setText("我小孩今年8岁,乘坐自行车摔倒擦伤了脸,使用什么方法才能不留疤痕?");
		tweet_listitem_usernametoptime.setText("2016-07-29");
		tweetcontenttclient.setText("来自于:华为");
//		  Map<String, Object> listItem = new HashMap<String, Object>();  
//		  listItem.put("imageids", R.drawable.menu1);  
//		  listItem.put("name","china");  
//		  listItem.put("desc", "中国中国中国中国中国中国中国");  
//		  listItems.add(listItem);  

//        SimpleAdapter simpleAdaptertop = new SimpleAdapter(getActivity(), listItems,
//		            R.layout.detailsimple_item, 
//		            new String[] { "imageids", "name", "desc"  },
//		            new int[] { R.id.tweet_listitem_userfacetop, R.id.tweet_listitem_usernametop,R.id.tweetcontenttop });
//			    lvinfo=(ListView)view.findViewById(R.id.tweet_listitem_details_contenttop);
//						lvinfo.setAdapter(simpleAdaptertop); // ΪListView��������
		
						
		for (int i = 0; i < replyname.length; i++) {  
        Map<String, Object> listItemsdetail = new HashMap<String, Object>();  
        listItemsdetail.put("replyimageids", replyimageids[i]);  
        listItemsdetail.put("replyname", replyname[i]);  
        listItemsdetail.put("replydesc", replydesc[i]);  
        listItemsdetail.put("timedetails", timedetails[i]);  
        listItemsdetail.put("clientdetails", clientdetails[i]);  
        listItemsdetail.put("sexmaleitem", sexmaleitem[i]);  
        listItemsdetails.add(listItemsdetail);  
    }  
	   
			SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listItemsdetails,
		            R.layout.detailsimple_item, 
		            new String[] { "replyimageids", "replyname", "replydesc","timedetails","clientdetails","sexmaleitem"},
		            new int[] { R.id.tweet_listitem_userfacetopp, R.id.tweet_listitem_usernametopp,R.id.tweetcontenttopp ,R.id.questiontimedetail,R.id.tweet_listitem_client_details,R.id.sexmaleitem});
			
			lvinfodetals=(ListView)view.findViewById(R.id.tweet_listitem_details_content);
			lvinfodetals.setAdapter(simpleAdapter); // ΪListView��������
			
		
			
						
		initView(view);
		return view;
	}
	private void initView(View view){
		
	
	}
	

	
	
}
