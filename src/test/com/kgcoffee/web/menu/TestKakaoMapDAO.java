package test.com.kgcoffee.web.menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.kakaoMap.dao.KakaoMapDAO;
import com.kgcoffee.web.kakaoMap.vo.KakaoMapVO;

class TestKakaoMapDAO {

	@Test
	void test() {

		KakaoMapDAO dao = KakaoMapDAO.getInstance();
		

		HashMap<String, Object> keyMap = new HashMap<String, Object>();

		ArrayList<KakaoMapVO> storeList = dao.findMap(keyMap);
		
		
		System.out.println(storeList.size());
		

	}

}
