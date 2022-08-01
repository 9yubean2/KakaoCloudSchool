package board.vo;

public class Board {
    private Integer boardId;
    private String boardTitle;
    private String memberId;
    private String boardContents;
    private String boardDate;
    private int likes;
    private int hits;
    private int commentCount;

    public Board() {
    }

    public Board(Integer boardId, String boardTitle, String memberId, String boardContents, String boardDate, int likes, int hits, int commentCount) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.memberId = memberId;
        this.boardContents = boardContents;
        this.boardDate = boardDate;
        this.likes = likes;
        this.hits = hits;
        this.commentCount = commentCount;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(String boardDate) {
        this.boardDate = boardDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
