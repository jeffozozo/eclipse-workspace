
public class track 
{
	trackSegment[] trackList;
	static final int num_segments = 6;
	
	public track()
	{
		
		trackList = new trackSegment[num_segments];
		
		trackList[0] = new trackSegment(.10,trackStyle.straight);
		trackList[1] = new trackSegment(.25,trackStyle.curve);
		trackList[2] = new trackSegment(.50,trackStyle.straight);
		trackList[3] = new trackSegment(.25,trackStyle.curve);
		trackList[4] = new trackSegment(.10,trackStyle.straight);
		trackList[5] = new trackSegment(.10,trackStyle.curve);
			
	}
	
	public trackSegment getSegment(int num_segment)
	{
		if(num_segment > num_segments)
			return null;
		
		return trackList[num_segment];
	}
	
	
	
	
}
