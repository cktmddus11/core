package hello.core;

public class ResultDto {
    private String rst;
    private String rstCd;
    private String rstMsg;

    public ResultDto() {
    }


    public ResultDto(String rst, String rstCd, String rstMsg) {
        this.rst = rst;
        this.rstCd = rstCd;
        this.rstMsg = rstMsg;
    }

    public ResultDto(String rst, String rstMsg) {
        this.rst = rst;
        this.rstMsg = rstMsg;
    }




    public String getRst() {
        return rst;
    }

    public void setRst(String rst) {
        this.rst = rst;
    }

    public String getRstCd() {
        return rstCd;
    }

    public void setRstCd(String rstCd) {
        this.rstCd = rstCd;
    }

    public String getRstMsg() {
        return rstMsg;
    }

    public void setRstMsg(String rstMsg) {
        this.rstMsg = rstMsg;
    }
}
