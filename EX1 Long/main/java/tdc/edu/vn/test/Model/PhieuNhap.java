package tdc.edu.vn.test.Model;

public class PhieuNhap {
    String maKho, soPhieu, ngayLap;

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    @Override
    public String toString() {
        return "PhieuNhap{" +
                "maKho='" + maKho + '\'' +
                ", soPhieu='" + soPhieu + '\'' +
                ", ngayLap='" + ngayLap + '\'' +
                '}';
    }
}
