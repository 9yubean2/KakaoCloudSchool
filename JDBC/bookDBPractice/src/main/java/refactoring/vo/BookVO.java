package refactoring.vo;
//VO,DTO 역할
//데이터 이동 수단
public class BookVO {
    private String bisbn;
    private String btitle;
    private String bauthor;

    public BookVO() {

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


    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }


}
