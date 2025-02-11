import java.lang.System;
import java.util.HashMap;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MannedViewer
{
	/*	java MannedViewer cmd man_num lang
	*/
	public static void main(String[] args)
	{
		URI uri;
		URL url;
		URLConnection con;
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		String s;

		HashMap<String,String> langs = new HashMap();
		HashMap<String,String> sections = new HashMap();
		{
			langs.put("en","");
			langs.put("cs",".cs");
			langs.put("da",".da");
			langs.put("de",".de");
			langs.put("de_DE",".de_DE");
			langs.put("es",".es");
			langs.put("fi",".fi");
			langs.put("fr",".fr");
			langs.put("hu",".hu");
			langs.put("id",".id");
			langs.put("it_IT",".it_IT");
			langs.put("ja",".ja");
			langs.put("ja_JA",".ja_JA");
			langs.put("ko",".ko");
			langs.put("ko_KR",".ko_KR");
			langs.put("nb",".nb");
			langs.put("nl",".nl");
			langs.put("pt",".pt");
			langs.put("pt_BR",".pt_BR");
			langs.put("ro",".ro");
			langs.put("ru",".ru");
			langs.put("ru_RU",".ru_RU");
			langs.put("sr",".sr");
			langs.put("sv",".sv");
			langs.put("tr",".tr");
			langs.put("uk",".uk");
			langs.put("vi",".vi");
			langs.put("zh_CN",".zh_CN");
			langs.put("zh_TW",".zh_TW");

			sections.put("1",".1");
			sections.put("2",".2");
			sections.put("2freebsd",".2freebsd");
			sections.put("3",".3");
			sections.put("3hal",".3hal");
			sections.put("3monocypher",".3monocypher");
			sections.put("3rtapi",".3rtapi");
			sections.put("3x",".3x");
			sections.put("3xgle",".3xgle");
			sections.put("3xglut",".3xglut");
			sections.put("4",".4");
			sections.put("4freebsd",".4freebsd");
			sections.put("5",".5");
			sections.put("6",".6");
			sections.put("7",".7");
			sections.put("8",".8");
			sections.put("8mandos",".8mandos");
			sections.put("9",".9");
			sections.put("9freebsd",".9freebsd");
			sections.put("l",".l");
		}

		String base_url = "https://manned.org/man";
		String cmd = "ls";
		String man_num = "1";
		String lang = "en";

		if(args.length > 3)
		{
			System.exit(1);
		}

		if(args.length >= 1)
		{
			cmd = args[0];
		}

		if(args.length >= 2)
		{
			man_num = args[1];
		}

		if(args.length == 3)
		{
			lang = args[2];
		}

		try
		{
			//uri = new URI("https://manned.org/man/ls.1");
			uri = new URI(base_url + langs.get(lang) + "/" + cmd + sections.get(man_num));
			url = uri.toURL();
			con = url.openConnection();
			is = con.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			s = br.readLine();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return;
		}

		while(null != s)
		{
			try
			{
				System.out.println(s);
				s = br.readLine();
			}
			catch(Exception e)
			{
				System.out.println(e);
				return;
			}
		}
	}
}
