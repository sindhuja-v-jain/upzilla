import java.util.LinkedList;
//import java.util.List;
import java.util.Queue;

class SiteStats {
    private String url;
    private int numVisits;

    /**
     * Constructor for the SiteStats class
     * 
     * @param url
     *            String that represents an URL that the user has visited
     * @param numVisits
     *            An int that represents the number of times that the user has
     *            visited the url
     */
    public SiteStats(String url, int numVisits) {
        this.url = url;
        this.numVisits = numVisits;
    }

    /**
     * This method returns the number of times that the user has visited the url.
     * 
     * @return An int that represents the number of times that the user has visited
     *         the url
     */
    public int getNumVisits() {
        return this.numVisits;
    }

    /**
     * This method returns the url that we are currently tracking
     * 
     * @return A String that represents the url that we are currently tracking
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * This method updates the number of times that we have visited the url
     * 
     * @param an
     *            int that represents the number that we want to set numVisits to
     */
    public void setNumVisits(int updatedNumVisits) {
        this.numVisits = updatedNumVisits;
    }

    public String toString() {
        return this.url + " | " + this.numVisits;
    }
}

public class SolutionB {

    private static Queue<SiteStats> sites = new LinkedList<SiteStats>();


    // Main method to list top n visited sites
    public static void listTopVisitedSites(Queue<SiteStats> sites, int n) {
        // WRITE CODE HERE
    	if(sites.isEmpty()) {
    		System.out.println(sites);
    		return;
    	}
    	SiteStats site = sites.remove(); //first element will be pulled&removed in variable site.
    	int count=sites.size();
    	int i=0;
    	while(count>0) { //this while loop will sort the queue.
    		SiteStats temp = sites.peek(); ////second element will be pulled in variable temp.
    		if(site.getNumVisits() > temp.getNumVisits()) {  // compare the visits and add in the queue.
    			sites.add(site);
    			site = sites.remove();
    			count--;
    		} else {
    			sites.add(sites.remove());
    			count--;
    		}
    		
    	}
    	sites.add(site);
    	//System.out.println(sites);
    	// below while loop will print the first n number of urls.
    	while(i<n){
    		System.out.println(sites.remove());
    		i++;
    	}
    	
    	
    	
    }

    // Method to find the website in the queue and increment the visited count by 1, adding new node in case website is not found
    /**
     * @param url
     */
    public static void updateCount(String url) {
        // WRITE CODE HERE
    	int count = sites.size();
    	boolean found = false;
    	// below while loop will update the count if already available in the queue.
    	while(count>0){
    		SiteStats site = sites.remove();
    		if(site !=null && url.equals(site.getUrl())){
    			found = true;
    			site.setNumVisits(site.getNumVisits()+1);
    		}
    		sites.add(site);
    		count--;
    	}
    	
    	// below if condition will add url and set visit count as 1, if it is coming first time in the queue.
    	if(!found){
    		sites.add(new SiteStats(url, 1));
    	}
     
    }

    public static void main(String[] args) {
        String[] visitedSites = { "www.google.co.in", "www.google.co.in", "www.facebook.com", "www.upgrad.com", "www.google.co.in", "www.youtube.com",
                "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in", "www.microsoft.com", "www.9gag.com", "www.netflix.com",
                "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com", "www.uber.com", "www.amazon.com",
                "www.microsoft.com", "www.upgrad.com" };
    	
    	
    	
        for (String url : visitedSites) {
            updateCount(url);
        }
        
        listTopVisitedSites(sites, 5);

    }

}

