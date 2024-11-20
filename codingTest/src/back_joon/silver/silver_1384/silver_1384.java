package back_joon.silver.silver_1384;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class silver_1384 {
	private static final String         GROUP_PREFIX = "Group ";
    private static final String NOBODY_NASTY_MESSAGE = "Nobody was nasty";
    private static final String NASTY_MESSAGE_FORMAT = "%s was nasty about %s";
    private static final String             NEW_LINE = "\n";
    private static final String           NASTY_MARK = "N";
	
	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			getResult(br);
		}
	}
	
	private static void getResult(BufferedReader br) throws IOException {
		int groupNumber = 1;
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				break;
			}
			
			System.out.println(getGroupHeader(groupNumber));
			
			List<String> papers = getPaper(br, n);
			processPaper(papers);
			groupNumber++;
		}
	}
	
	private static String getGroupHeader(int groupNumber) {
		return (groupNumber == 1 ? "" : NEW_LINE) + GROUP_PREFIX + groupNumber;
	}
	
	private static List<String> getPaper(BufferedReader br, int n) throws IOException {
		List<String> papers = new ArrayList<String>();
		
		for(int i=0; i<n; i++) {
			papers.add(br.readLine());
		}
		
		return papers;
	}
	
	private static void processPaper(List<String> papers) {
		int badStudentCount = 0;
		
		for(int i=0; i<papers.size(); i++) {
			badStudentCount += processReview(papers, i);
		}
		
		if(badStudentCount == 0) {
			System.out.println(NOBODY_NASTY_MESSAGE);
		}
	}
	
	private static int processReview(List<String> papers, int currentIdx) {
		StringTokenizer st = new StringTokenizer(papers.get(currentIdx));
		String  paperOwner = st.nextToken();
		int badReviewCount = 0;
		
		for(int prev = 1; st.hasMoreElements(); prev++) {
			if(NASTY_MARK.equals(st.nextToken())) {
				String writerName = getWriterName(papers, currentIdx, prev);
				
				System.out.println(String.format(NASTY_MESSAGE_FORMAT, writerName, paperOwner));
				badReviewCount++;
			}
		}
		
		return badReviewCount;
	}
	
	private static String getWriterName(List<String> papers, int currentIdx, int prev) {
		int writerIdx = (currentIdx - prev + papers.size()) % papers.size();
		
		return new StringTokenizer(papers.get(writerIdx)).nextToken();
	}
}
