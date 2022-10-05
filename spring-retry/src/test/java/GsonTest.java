import com.google.gson.Gson;
import com.wx.web.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 22343
 * @version 1.0
 * @date 2022/10/5 12:39
 */
public class GsonTest {
	
	@Test
	public void gson() {
		Gson gson = new Gson();
		Result fail = Result.fail("message","test retry failed");
		String resultFail = gson.toJson(fail);
		System.out.printf("gson: %s\n",resultFail);
		//language=JSON
		String json = "[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\"]";
		Collection<Integer> arrayList = gson.fromJson(json,ArrayList.class);
		System.out.printf("arrayList: %s\n",arrayList);
		System.out.println();
	}
	
	
}
