-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2021 at 01:40 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qltv`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieumuon`
--

CREATE TABLE `chitietphieumuon` (
  `MaCTPM` int(11) NOT NULL,
  `MaPM` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `NgayTra` varchar(244) NOT NULL,
  `GhiChu` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietphieumuon`
--

INSERT INTO `chitietphieumuon` (`MaCTPM`, `MaPM`, `MaSach`, `NgayTra`, `GhiChu`, `TrangThai`) VALUES
(29, 19, 32, '2021-09-22', '', 1),
(30, 19, 32, '2021-09-22', 'Chưa hết hạn', 1),
(31, 19, 29, '2021-09-22', 'Chưa hết hạn', 1),
(32, 19, 27, '2021-09-22', 'Chưa hết hạn', 1),
(33, 20, 32, '2021-09-22', 'Chưa hết hạn', 1),
(34, 20, 27, '2021-09-22', 'Chưa hết hạn', 1),
(35, 20, 31, '2021-09-22', 'Chưa hết hạn', 1);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaCTPN` int(11) NOT NULL,
  `MaPN` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `Gia` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaCTPN`, `MaPN`, `MaSach`, `Gia`, `SoLuong`, `ThanhTien`) VALUES
(18, 16, 27, 10000, 10, 100000),
(19, 16, 28, 15000, 20, 300000);

-- --------------------------------------------------------

--
-- Table structure for table `docgia`
--

CREATE TABLE `docgia` (
  `madocgia` int(11) NOT NULL,
  `tendocgia` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `docgia`
--

INSERT INTO `docgia` (`madocgia`, `tendocgia`, `gioitinh`, `diachi`, `sdt`, `TrangThai`) VALUES
(14, 'Võ Hoàng Kiệt', 'Nam', 'Long An', '0396527908', 1),
(15, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 1);

-- --------------------------------------------------------

--
-- Table structure for table `kesach`
--

CREATE TABLE `kesach` (
  `MaKe` int(11) NOT NULL,
  `ViTri` varchar(255) DEFAULT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kesach`
--

INSERT INTO `kesach` (`MaKe`, `ViTri`, `TrangThai`) VALUES
(13, 'Kệ 1', 1),
(14, 'Kệ 2', 1),
(15, 'Kệ 3', 1),
(16, 'Kệ 4', 1),
(17, 'Kệ 5', 1);

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE `loai` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`MaLoai`, `TenLoai`, `TrangThai`) VALUES
(12, 'CNTT', 1),
(13, 'Khoa Học', 1),
(14, 'Truyện Tranh', 1),
(15, 'Truyện cổ tích', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` int(11) NOT NULL,
  `TenNCC` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `TrangThai`) VALUES
(1, 'Võ Hoàng Kiệt', 1),
(2, 'Ngô Phú Khang2', 1),
(3, 'Nguyễn Văn Cừ', 1),
(4, 'Fahasa', 1),
(6, 'Huỳnh Hoàng Phúc', 0),
(7, 'Nguyễn Đình Trí', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` int(11) NOT NULL,
  `TenNV` varchar(255) NOT NULL,
  `NamSinh` varchar(11) NOT NULL,
  `GioiTinh` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `Sdt` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `NamSinh`, `GioiTinh`, `DiaChi`, `Sdt`, `TrangThai`) VALUES
(35, 'Nhân Viên 1', '2001', 'Nam', 'Long An', '0396527908', 1),
(36, 'Nhân Viên 2', '2002', 'Nam', 'Cà Mau', '0396527908', 1),
(37, 'Nhân Viên 3', '2000', 'Nữ', 'Bến Tre', '0396527908', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `MaNXB` int(11) NOT NULL,
  `TenNXB` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `Sdt` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`MaNXB`, `TenNXB`, `DiaChi`, `Sdt`, `TrangThai`) VALUES
(13, 'Nhà Xuất Bản Số1 ', 'Hồ Chí Minh', '0396527908', 1),
(14, 'Nhà Xuất Bản Số 2', 'Hồ Chí Minh', '0396527909', 1),
(15, 'Nhà Xuất Bản Số 3', 'Hồ Chí Minh', '0396527910', 1),
(16, 'Nhà Xuất Bản Số 4', 'Hồ Chí Minh', '0396527911', 1),
(17, 'Nhà Xuất Bản Số 5', 'Hồ Chí Minh', '0396527912', 0),
(18, 'Nhà Xuất Bản Số 6', 'Hồ Chí Minh', '0396527913', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phat`
--

CREATE TABLE `phat` (
  `mapp` int(11) NOT NULL,
  `mapm` int(11) NOT NULL,
  `lydo` varchar(255) NOT NULL,
  `tien` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieumuon`
--

CREATE TABLE `phieumuon` (
  `MaPM` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaDocGia` int(11) NOT NULL,
  `NgayMuon` varchar(255) NOT NULL,
  `TinhTrang` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieumuon`
--

INSERT INTO `phieumuon` (`MaPM`, `MaNV`, `MaDocGia`, `NgayMuon`, `TinhTrang`, `TrangThai`) VALUES
(19, 35, 14, '2021-09-15', 'Đã Trả', 1),
(20, 35, 14, '2021-09-15', 'Đang Mượn', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieuNhap` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `NgayNhap` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPhieuNhap`, `MaNCC`, `MaNV`, `NgayNhap`, `TrangThai`) VALUES
(16, 2, 36, '2021-09-15', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MaSach` int(11) NOT NULL,
  `TenSach` varchar(255) NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `MaNXB` int(11) NOT NULL,
  `MaTacGia` int(11) NOT NULL,
  `NamXB` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Make` int(11) NOT NULL,
  `HinhAnh` text NOT NULL,
  `TrangThai` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `MaLoai`, `MaNXB`, `MaTacGia`, `NamXB`, `SoLuong`, `Make`, `HinhAnh`, `TrangThai`) VALUES
(27, 'Quyển Sách 1', 13, 14, 15, 2021, 19, 13, 'haihuoc.jpg', '1'),
(28, 'Quyển Sách 2', 12, 15, 16, 2020, 30, 14, '8936067597936.jpg', '1'),
(29, 'Quyển Sách 3', 14, 16, 17, 2019, 20, 13, '8936067597936.jpg', '1'),
(30, 'Quyển Sách 4', 15, 18, 16, 2019, 10, 13, 'macbiet.jpg', '1'),
(31, 'Quyển Sách 5', 14, 16, 16, 2019, 9, 13, 'biamem.jpg', '1'),
(32, 'Quyển Sách 6', 14, 16, 16, 2019, 9, 13, 'biaao_bithuongnguocdongthanhsong_3.jpg', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTacGia` int(11) NOT NULL,
  `TenTacGia` varchar(255) NOT NULL,
  `NamSinh` varchar(4) NOT NULL,
  `QueQuan` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`MaTacGia`, `TenTacGia`, `NamSinh`, `QueQuan`, `TrangThai`) VALUES
(14, 'Tác Giả 1', '2001', 'Long An', 1),
(15, 'Tác Giả 2', '2002', 'Long An', 1),
(16, 'Tác Giả 3', '2000', 'Long An', 1),
(17, 'Tác Giả 4', '1999', 'Long An', 1);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `matk` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `quyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`matk`, `username`, `password`, `quyen`) VALUES
(1, 'admin', 'admin ', 0),
(35, 'nv1', 'npnn2001 ', 1);

-- --------------------------------------------------------

--
-- Table structure for table `thethuvien`
--

CREATE TABLE `thethuvien` (
  `MaTheThuVien` int(11) NOT NULL,
  `NgayBatDau` varchar(255) NOT NULL,
  `NgayKetThuc` varchar(255) NOT NULL,
  `GhiChu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thethuvien`
--

INSERT INTO `thethuvien` (`MaTheThuVien`, `NgayBatDau`, `NgayKetThuc`, `GhiChu`) VALUES
(14, '2021-09-15', '2021-09-15', NULL),
(15, '2021-09-15', '2021-09-30', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD PRIMARY KEY (`MaCTPM`),
  ADD KEY `MaPM` (`MaPM`),
  ADD KEY `MaSach` (`MaSach`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaCTPN`),
  ADD KEY `MaSach` (`MaSach`),
  ADD KEY `MaPN` (`MaPN`);

--
-- Indexes for table `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`madocgia`);

--
-- Indexes for table `kesach`
--
ALTER TABLE `kesach`
  ADD PRIMARY KEY (`MaKe`);

--
-- Indexes for table `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`MaNXB`);

--
-- Indexes for table `phat`
--
ALTER TABLE `phat`
  ADD PRIMARY KEY (`mapp`),
  ADD KEY `mapm` (`mapm`);

--
-- Indexes for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`MaPM`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaDocGia` (`MaDocGia`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`),
  ADD KEY `MaLoai` (`MaLoai`),
  ADD KEY `MaNXB` (`MaNXB`),
  ADD KEY `MaTacGia` (`MaTacGia`),
  ADD KEY `Make` (`Make`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`MaTacGia`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`matk`);

--
-- Indexes for table `thethuvien`
--
ALTER TABLE `thethuvien`
  ADD PRIMARY KEY (`MaTheThuVien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  MODIFY `MaCTPM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  MODIFY `MaCTPN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `docgia`
--
ALTER TABLE `docgia`
  MODIFY `madocgia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `kesach`
--
ALTER TABLE `kesach`
  MODIFY `MaKe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `loai`
--
ALTER TABLE `loai`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `MaNCC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  MODIFY `MaNXB` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `phat`
--
ALTER TABLE `phat`
  MODIFY `mapp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `phieumuon`
--
ALTER TABLE `phieumuon`
  MODIFY `MaPM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MaPhieuNhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `MaSach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `MaTacGia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD CONSTRAINT `chitietphieumuon_ibfk_1` FOREIGN KEY (`MaPM`) REFERENCES `phieumuon` (`MaPM`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieumuon_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPhieuNhap`);

--
-- Constraints for table `phat`
--
ALTER TABLE `phat`
  ADD CONSTRAINT `phat_ibfk_1` FOREIGN KEY (`mapm`) REFERENCES `phieumuon` (`MaPM`);

--
-- Constraints for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `phieumuon_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `phieumuon_ibfk_2` FOREIGN KEY (`MaDocGia`) REFERENCES `docgia` (`madocgia`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loai` (`MaLoai`),
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`MaNXB`) REFERENCES `nhaxuatban` (`MaNXB`),
  ADD CONSTRAINT `sach_ibfk_3` FOREIGN KEY (`MaTacGia`) REFERENCES `tacgia` (`MaTacGia`),
  ADD CONSTRAINT `sach_ibfk_4` FOREIGN KEY (`Make`) REFERENCES `kesach` (`MaKe`);

--
-- Constraints for table `thethuvien`
--
ALTER TABLE `thethuvien`
  ADD CONSTRAINT `thethuvien_ibfk_1` FOREIGN KEY (`MaTheThuVien`) REFERENCES `docgia` (`madocgia`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
