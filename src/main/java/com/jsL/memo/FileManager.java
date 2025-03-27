package com.jsL.memo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	public static final String FILE_UPLOAD_PATH = "C:\\Users\\user\\Desktop\\jh\\project\\upload\\memo";
	
	//파일 저장 기능
	public static String saveFile(int userId, MultipartFile file) {
		
		
		
		if(file == null) {
			return null;
		}
		
		// 파일 이름 유지
		// 폴더를 생성해서 파일을 저장
		// 사용자 정보를 폴더 이름으로 사용한다.
		// 시간 정보를 포함 
		// uniㅌ타임 : 1970년 1월 1일 0시 0분 0초부터 흐릉 시가간으로 mitil ㄴㄷ채ㅜㅇ(/1100)단위표 표현값
		
		
	 String dictionalryName = "/"	+  userId +  "_" + System.currentTimeMillis();
		
			 
	
	
	
	String directoryPath = FILE_UPLOAD_PATH + dictionalryName;
	
	File directory = new File(directoryPath);	
	
	if(!directory.mkdir()) {
		//디렉토리 생성 실패
		return null;
	}
	//파일 저장
	String filePath = directoryPath + "/" + file.getOriginalFilename();	
	
	
	try {
		byte[] bytes = file.getBytes();
		
		Path path = Paths.get(filePath);
		Files.write(path,  bytes);
		
	}
	catch (IOException e) {
		
	
		
		
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	
	}
	
	//실재 파일 저장위치와 url 경로를 매칭하는 규칙
	//"C:\\Users\\user\\Desktop\\jh\\project\\upload\\memo";
	//  /imges/
	
	//"C:\\Users\\user\\Desktop\\jh\\project\\upload\\memo_5423423/text.png";
	//images/5_3242/text.png
	
	
	return "/images" + dictionalryName + "/" +file.getOriginalFilename();
	
	
	}
	
	//파일 삭제 기능
	public static boolean removeFile(String imgPath){ // /images/2_1742384971937
		
		
		
		if(imgPath == null) {//이미지가 없을 때
			return false;
		}
		
		String fullFillPath = FILE_UPLOAD_PATH + imgPath.replace("/images", "");
		
		Path path = Paths.get(fullFillPath);
	//"C:\\Users\\user\\Desktop\\jh\\project\\upload\\memo_5423423/text.png";
		
		Path directoryPath = path.getParent();//파일을 저장하고 있는 상위 정보
		
		
		try {
			Files.delete(path);
			Files.delete(directoryPath);
		} catch (IOException e) {
			
			return false;
		}
		
		
		
		return true;
		
		
		
	}
	
	
	
	
	
	
	
	
	//  /imges/
}
