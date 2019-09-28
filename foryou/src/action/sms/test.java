package action.sms;

//java.util.*, java.security.*, java.io.*, java.net.*
import java.util.*;
import java.security.*;
import java.io.*;
import java.net.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test {

   

   public String testSMS(String tel,HttpServletRequest request, HttpServletResponse response) {
	   Random rnd = new Random();
		String randomStr = String.valueOf(rnd.nextInt(10))+String.valueOf(rnd.nextInt(10))+String.valueOf(rnd.nextInt(10))
		+String.valueOf(rnd.nextInt(10))+String.valueOf(rnd.nextInt(10))+String.valueOf(rnd.nextInt(10));
		request.setAttribute("randomStr", randomStr);
	   String subject = "test subject 입니다";
	   String contents = "[for you]본인확인 인증번호  ["+randomStr+"]를 입력해주세요.";
	   
	   sendSMS(request,response,tel,contents,subject);
	   return randomStr;
   }
   

   // sms �넚�떊遺�遺�. 嫄대뱾吏�留덉꽭�슂
   private void sendSMS(HttpServletRequest request, HttpServletResponse response, String tel, String contents, String inputSubject) {

      String charsetType = "UTF-8"; // EUC-KR �삉�뒗 UTF-8

      try {
         request.setCharacterEncoding(charsetType);
         response.setCharacterEncoding(charsetType);
         // String action = nullcheck(request.getParameter("action"), "");

         String sms_url = "";
         sms_url = "https://sslsms.cafe24.com/sms_sender.php"; // SMS �쟾�넚�슂泥� URL
         String user_id = base64Encode("dodunge"); // SMS�븘�씠�뵒
         String secure = base64Encode("d97b8579544c3ea2be3dc17f2b70aba4");// �씤利앺궎

         String inputmsg = contents;
         String inputrphone = "010-5478-3506";
         String inputsphone1 = "010";
         String inputsphone2 = "5478";
         String inputsphone3 = "3506";

         String msg = base64Encode(nullcheck(inputmsg, ""));
         String rphone = base64Encode(nullcheck(inputrphone, ""));
         String sphone1 = base64Encode(nullcheck(inputsphone1, ""));
         String sphone2 = base64Encode(nullcheck(inputsphone2, ""));
         String sphone3 = base64Encode(nullcheck(inputsphone3, ""));
         String rdate = base64Encode("");
         String rtime = base64Encode("");
         // out.print(msg);
         String mode = base64Encode("1");
         String subject = base64Encode(inputSubject);
         /*
          * if (nullcheck(request.getParameter("smsType"), "").equals("L")) { subject =
          * base64Encode(nullcheck(request.getParameter("subject"), "")); }
          */
         String testflag = base64Encode("");
         String destination = base64Encode(nullcheck(tel, ""));
         String repeatFlag = base64Encode("");
         String repeatNum = base64Encode("");
         String repeatTime = base64Encode("");
         String returnurl = "";
         String nointeractive = "";
         String smsType = base64Encode("S");

         String[] host_info = sms_url.split("/");
         String host = host_info[2];
         String path = "/" + host_info[3];
         int port = 80;

         // �뜲�씠�꽣 留듯븨 蹂��닔 �젙�쓽
         String arrKey[] = new String[] { "user_id", "secure", "msg", "rphone", "sphone1", "sphone2", "sphone3",
               "rdate", "rtime", "mode", "testflag", "destination", "repeatFlag", "repeatNum", "repeatTime",
               "smsType", "subject" };
         String valKey[] = new String[arrKey.length];
         valKey[0] = user_id;
         valKey[1] = secure;
         valKey[2] = msg;
         valKey[3] = rphone;
         valKey[4] = sphone1;
         valKey[5] = sphone2;
         valKey[6] = sphone3;
         valKey[7] = rdate;
         valKey[8] = rtime;
         valKey[9] = mode;
         valKey[10] = testflag;
         valKey[11] = destination;
         valKey[12] = repeatFlag;
         valKey[13] = repeatNum;
         valKey[14] = repeatTime;
         valKey[15] = smsType;
         valKey[16] = subject;

         String boundary = "";
         Random rnd = new Random();
         String rndKey = Integer.toString(rnd.nextInt(32000));
         MessageDigest md = MessageDigest.getInstance("MD5");
         byte[] bytData = rndKey.getBytes();
         md.update(bytData);
         byte[] digest = md.digest();
         for (int i = 0; i < digest.length; i++) {
            boundary = boundary + Integer.toHexString(digest[i] & 0xFF);
         }
         boundary = "---------------------" + boundary.substring(0, 11);

         // 蹂몃Ц �깮�꽦
         String data = "";
         String index = "";
         String value = "";
         for (int i = 0; i < arrKey.length; i++) {
            index = arrKey[i];
            value = valKey[i];
            data += "--" + boundary + "\r\n";
            data += "Content-Disposition: form-data; name=\"" + index + "\"\r\n";
            data += "\r\n" + value + "\r\n";
            data += "--" + boundary + "\r\n";
         }

         // out.println(data);

         InetAddress addr = InetAddress.getByName(host);
         Socket socket = new Socket(host, port);
         // �뿤�뜑 �쟾�넚
         BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetType));
         wr.write("POST " + path + " HTTP/1.0\r\n");
         wr.write("Content-Length: " + data.length() + "\r\n");
         wr.write("Content-type: multipart/form-data, boundary=" + boundary + "\r\n");
         wr.write("\r\n");

         // �뜲�씠�꽣 �쟾�넚
         wr.write(data);
         wr.flush();

         /*
          * // 寃곌낵媛� �뼸湲� BufferedReader rd = new BufferedReader(new
          * InputStreamReader(socket.getInputStream(),charsetType)); String line; String
          * alert = ""; ArrayList tmpArr = new ArrayList(); while ((line = rd.readLine())
          * != null) { tmpArr.add(line); } wr.close(); rd.close();
          * 
          * String tmpMsg = (String)tmpArr.get(tmpArr.size()-1); String[] rMsg =
          * tmpMsg.split(","); String Result= rMsg[0]; //諛쒖넚寃곌낵 String Count= ""; //�옍�뿬嫄댁닔
          * if(rMsg.length>1) {Count= rMsg[1]; }
          */
         /*
          * //諛쒖넚寃곌낵 �븣由� if(Result.equals("success")) { alert = "�꽦怨듭쟻�쑝濡� 諛쒖넚�븯���뒿�땲�떎."; alert +=
          * " �옍�뿬嫄댁닔�뒗 "+ Count+"嫄� �엯�땲�떎."; } else if(Result.equals("reserved")) { alert =
          * "�꽦怨듭쟻�쑝濡� �삁�빟�릺�뿀�뒿�땲�떎"; alert += " �옍�뿬嫄댁닔�뒗 "+ Count+"嫄� �엯�땲�떎."; } else
          * if(Result.equals("3205")) { alert = "�옒紐삳맂 踰덊샇�삎�떇�엯�땲�떎."; } else { alert =
          * "[Error]"+Result; }
          */

         /*
          * out.println(nointeractive);
          * 
          * if(nointeractive.equals("1") && !(Result.equals("Test Success!")) &&
          * !(Result.equals("success")) && !(Result.equals("reserved")) ) {
          * out.println("<script>alert('" + alert + "')</script>"); } else
          * if(!(nointeractive.equals("1"))) { out.println("<script>alert('" + alert +
          * "')</script>"); }
          * 
          * 
          * response.sendRedirect("index.jsp");
          */
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static String nullcheck(String str, String Defaultvalue) throws Exception {
      String ReturnDefault = "";
      if (str == null) {
         ReturnDefault = Defaultvalue;
      } else if (str == "") {
         ReturnDefault = Defaultvalue;
      } else {
         ReturnDefault = str;
      }
      return ReturnDefault;
   }

   /**
    * BASE64 Encoder
    * 
    * @param str
    * @return
    */
   private static String base64Encode(String str) throws java.io.IOException {
      sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
      byte[] strByte = str.getBytes();
      String result = encoder.encode(strByte);
      return result;
   }

   /**
    * BASE64 Decoder
    * 
    * @param str
    * @return
    */
   private static String base64Decode(String str) throws java.io.IOException {
      sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
      byte[] strByte = decoder.decodeBuffer(str);
      String result = new String(strByte);
      return result;
   }
}