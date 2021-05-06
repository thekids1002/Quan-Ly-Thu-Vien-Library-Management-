-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2021 at 05:33 AM
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
  `GhiChu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietphieumuon`
--

INSERT INTO `chitietphieumuon` (`MaCTPM`, `MaPM`, `MaSach`, `NgayTra`, `GhiChu`) VALUES
(19, 12, 22, '2021-04-28', 'Đã Hết Hạn'),
(20, 12, 17, '2021-04-28', 'Hôm nay là hạn cuối'),
(21, 13, 19, '2021-04-29', 'Hôm nay là hạn cuối');

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
(1, 1, 2, 10000, 10, 100000),
(3, 4, 3, 10000, 10, 100000),
(4, 4, 5, 10000, 20, 200000),
(5, 5, 4, 1111, 2, 2222),
(6, 6, 4, 15000, 10, 150000),
(7, 6, 5, 15000, 9, 135000),
(8, 7, 13, 10000, 10, 100000),
(10, 7, 13, 100000, 20, 2000000),
(11, 9, 13, 15000, 10, 150000),
(12, 9, 15, 30000, 15, 450000),
(13, 9, 15, 15, 4000, 60000),
(14, 9, 15, 11111, 500, 5555500),
(15, 10, 17, 15000, 3, 45000),
(16, 11, 19, 15000, 10, 150000);

-- --------------------------------------------------------

--
-- Table structure for table `docgia`
--

CREATE TABLE `docgia` (
  `madocgia` int(11) NOT NULL,
  `tendocgia` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `docgia`
--

INSERT INTO `docgia` (`madocgia`, `tendocgia`, `gioitinh`, `diachi`, `sdt`) VALUES
(4, 'Trần Hữu Khương', 'Nam', 'Đồng Nai', '0391266216'),
(6, 'Trần Văn Khang', 'Nam', 'Long Xuyên', '038126612'),
(7, 'Nguyễn Đình Trí', 'Nam', 'Đồng Nai', '21737128'),
(8, 'Nguyễn Trần Huỳnh Long', 'Nam', 'HCM', '1286172673');

-- --------------------------------------------------------

--
-- Table structure for table `kesach`
--

CREATE TABLE `kesach` (
  `MaKe` int(11) NOT NULL,
  `ViTri` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kesach`
--

INSERT INTO `kesach` (`MaKe`, `ViTri`) VALUES
(2, 'Kệ 1'),
(5, 'Kệ 2'),
(6, 'Kệ 3'),
(8, 'Kệ 4'),
(9, 'jhu C');

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE `loai` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`MaLoai`, `TenLoai`) VALUES
(3, 'Trinh Thám'),
(4, 'Văn học'),
(5, 'Kinh Tế'),
(6, 'Khoa học tự nhiên'),
(7, 'Lập trình cntt'),
(8, 'Manga');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` int(11) NOT NULL,
  `TenNCC` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`) VALUES
(1, 'Võ Hoàng Kiệt'),
(2, 'Ngô Phú Khang'),
(3, 'Nguyễn Văn Cừ'),
(4, 'Fahasa'),
(6, 'Huỳnh Hoàng Phúc'),
(7, 'Nguyễn Đình Trí');

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
  `Sdt` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `NamSinh`, `GioiTinh`, `DiaChi`, `Sdt`) VALUES
(29, 'Võ Hoàng Kiệt', '2001', 'Nam', 'HCM', '823648328'),
(30, 'Ngô Phú Khang', '2001', 'Nam', 'HCM', '2137213821'),
(31, 'Huỳnh Hoàng Phúc', '2001', 'Nam', 'HCM', '273771'),
(32, 'Nguyễn Trần Huỳnh Long', '2001', 'Nam', 'HCM', '273771212');

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `MaNXB` int(11) NOT NULL,
  `TenNXB` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `Sdt` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`MaNXB`, `TenNXB`, `DiaChi`, `Sdt`) VALUES
(1, 'Tuổi Trẻ', 'Long AN', '03927626631'),
(2, 'Đại Học Sài Gòn Cơ Sở 2', 'An Dương Vương quận 5', '039266163'),
(7, 'Nhà Xuất Bản Trẻ', 'TP HCM', '12712812312'),
(8, 'NXB Hồng Đức', 'TP HCM', '073589663'),
(9, 'Tuổi Hồng 1', 'HCM', '1273721'),
(10, 'Tuổi Hồng', 'TP HCM', '1273721');

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

--
-- Dumping data for table `phat`
--

INSERT INTO `phat` (`mapp`, `mapm`, `lydo`, `tien`) VALUES
(1, 1, 'Hỏng Sách', '10000'),
(2, 10, 'Hỏng Sách', '111111'),
(3, 10, 'Không Đúng Sách Đã Mượn', '111100'),
(4, 11, 'Hỏng Sách', '10000'),
(5, 11, 'Mất Sách', '1111111'),
(6, 13, 'Hỏng Sách', '10000'),
(7, 12, 'Hỏng Sách', '1000000');

-- --------------------------------------------------------

--
-- Table structure for table `phieumuon`
--

CREATE TABLE `phieumuon` (
  `MaPM` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaDocGia` int(11) NOT NULL,
  `NgayMuon` varchar(255) NOT NULL,
  `TinhTrang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieumuon`
--

INSERT INTO `phieumuon` (`MaPM`, `MaNV`, `MaDocGia`, `NgayMuon`, `TinhTrang`) VALUES
(12, 32, 7, '2021-04-28', 'Đã Trả'),
(13, 30, 4, '2021-04-28', 'Đang Mượn'),
(14, 29, 3, '2021-04-29', 'Đang Mượn');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieuNhap` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `NgayNhap` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPhieuNhap`, `MaNCC`, `MaNV`, `NgayNhap`) VALUES
(3, 1, 3, '2021-03-05'),
(4, 2, 7, '2021-04-07'),
(5, 1, 25, '2021-04-07'),
(6, 2, 17, '2021-04-14'),
(7, 2, 28, '2021-04-25'),
(8, 2, 22, '2021-04-26'),
(9, 1, 28, '2021-04-27');

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
  `GhiChu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `MaLoai`, `MaNXB`, `MaTacGia`, `NamXB`, `SoLuong`, `Make`, `HinhAnh`, `GhiChu`) VALUES
(13, 'Lập Trình C', 3, 1, 3, 2021, 14, 2, '61456.png', NULL),
(15, 'Lập Trình C#', 3, 1, 3, 2021, 10, 2, '61456.png', NULL),
(16, 'Lập Trình Java', 3, 1, 3, 2025, 1, 2, 'bookicon.png', NULL),
(17, 'Mắc Biết', 3, 1, 3, 1999, 12, 2, 'macbiet.jpg', NULL),
(18, 'Những Mẫu Chuyện Hài Hước', 3, 1, 3, 2002, 10, 2, 'haihuoc.jpg', NULL),
(19, 'Ba Ngày Hạnh Phúc', 3, 1, 3, 2019, 10, 2, 'bia-1-3-ngay-hp.jpg', NULL),
(20, 'Bi Thương Ngược Dòng Thành Sông', 4, 8, 11, 2019, 10, 2, 'biaao_bithuongnguocdongthanhsong_3.jpg', NULL),
(21, 'Ông Già Và Biển Cả', 4, 7, 7, 2019, 15, 2, '8936067597936.jpg', NULL),
(22, 'Hai Số Phận - Bìa Cứng', 4, 7, 11, 2019, 14, 2, 'haisophan.jpg', NULL),
(23, 'Mùa Hè Của Quỷ Thai', 3, 8, 11, 2012, 15, 6, 'mua-he-cua-quy-thai_bia1.jpg', NULL),
(24, 'Con Chim Xanh Biếc Bay Về', 4, 7, 7, 2020, 20, 5, 'biamem.jpg', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTacGia` int(11) NOT NULL,
  `TenTacGia` varchar(255) NOT NULL,
  `NamSinh` varchar(4) NOT NULL,
  `QueQuan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`MaTacGia`, `TenTacGia`, `NamSinh`, `QueQuan`) VALUES
(3, 'Nguyễn Ngọc Ánh', '1994', 'Nghệ An'),
(4, 'Nguyễn Ngọc Ánh', '1994', 'Nghệ An'),
(7, 'Nguyễn Văn Cừ', '1989', 'Sài Gòn'),
(10, 'Võ Hoàng Kiey', '1995', 'Nghệ An'),
(11, 'Quách Kim Minh', '1985', 'Bến Tre');

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
(6, 'testthemtaikhoan', '111111 ', 1),
(24, 'khang123', '123456 ', 1),
(25, 'sang', '1234 ', 1),
(26, 'gameooff11111', 'kietlun147 ', 1),
(27, 'phukim', '12345 ', 0),
(28, 'khuongsake', '123456 ', 1),
(30, 'ngokhang', 'khang123', 1);

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
(4, '2021-04-29', '2021-04-30', NULL),
(6, '2021-04-29', '2021-04-30', NULL);

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
  ADD PRIMARY KEY (`MaCTPN`);

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
  ADD PRIMARY KEY (`mapp`);

--
-- Indexes for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`MaPM`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`);

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
  MODIFY `MaCTPM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  MODIFY `MaCTPN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `docgia`
--
ALTER TABLE `docgia`
  MODIFY `madocgia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `kesach`
--
ALTER TABLE `kesach`
  MODIFY `MaKe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `loai`
--
ALTER TABLE `loai`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `MaNCC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  MODIFY `MaNXB` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `phat`
--
ALTER TABLE `phat`
  MODIFY `mapp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `phieumuon`
--
ALTER TABLE `phieumuon`
  MODIFY `MaPM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MaPhieuNhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `MaSach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `MaTacGia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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
-- Constraints for table `thethuvien`
--
ALTER TABLE `thethuvien`
  ADD CONSTRAINT `thethuvien_ibfk_1` FOREIGN KEY (`MaTheThuVien`) REFERENCES `docgia` (`madocgia`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
