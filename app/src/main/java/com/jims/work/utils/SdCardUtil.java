/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package com.jims.work.utils;

import android.os.Environment;

import java.io.File;

public class SdCardUtil {

	
	//项目文件根目录
	public static final String FILEDIR="/moodInn";
	
	//照相机照片目录
	public static final String FILEPHOTO="/photos";
	
	//应用程序图片存放
	public static final String FILEIMAGE="images";
	
	//应用程序缓存
	public static final String FILECACHE="cache";
	
	//用户信息目录
	public static final String FILEUSER="user";
	
	/**
	 * 检测sd卡是否可以用
	 * 
	 * @return
	 */
	public static boolean checkSdCard() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			// sd card 可用
			return true;
		} else {
			// 当前不可用
			return false;
		}
	}

	/**
	 * 获取sd卡文件路径
	 * 
	 * @return
	 */
	public static String getSdPath() {
		return Environment.getExternalStorageDirectory()+"/";
	}

	/**
	 * 创建一个项目文件夹
	 * 
	 * @param fileDir
	 *            文件目录名
	 */
	public static void createFileDir(String fileDir) {
		String path = getSdPath() + fileDir;
		File path1 = new File(path);
		if (!path1.exists()) {
			path1.mkdirs();
			//LogUtil.i("我被创建成功了...");
		}
	}
	
	
	
}
