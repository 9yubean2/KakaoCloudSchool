package lecture0721.simplebooksearch.vo;
//VO,DTO 역할
//데이터 이동 수단
public class BookVO {
    private String bisbn;
    private String btitle;
    private String bdate;
    private int bpage;
    private int bprice ;
    private String bauthor;


    public BookVO() {

    }

    public BookVO(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor) {
        this.bisbn = bisbn;
        this.btitle = btitle;
        this.bdate = bdate;
        this.bpage = bpage;
        this.bprice = bprice;
        this.bauthor = bauthor;

    }

    public String getBisbn() {
        return bisbn;
    }

    public void setBisbn(String bisbn) {
        this.bisbn = bisbn;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public int getBpage() {
        return bpage;
    }

    public void setBpage(int bpage) {
        this.bpage = bpage;
    }

    public int getBprice() {
        return bprice;
    }

    public void setBprice(int bprice) {
        this.bprice = bprice;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }


}
