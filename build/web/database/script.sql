USE [master]
GO
/****** Object:  Database [PRJ301_Assignment]    Script Date: 07/16/2021 11:03:41 ******/
CREATE DATABASE [PRJ301_Assignment] ON  PRIMARY 
( NAME = N'PRJ301_Assignment', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\PRJ301_Assignment.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PRJ301_Assignment_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\PRJ301_Assignment_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PRJ301_Assignment] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRJ301_Assignment].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRJ301_Assignment] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET ANSI_NULLS OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET ANSI_PADDING OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET ARITHABORT OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [PRJ301_Assignment] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [PRJ301_Assignment] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [PRJ301_Assignment] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET  DISABLE_BROKER
GO
ALTER DATABASE [PRJ301_Assignment] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [PRJ301_Assignment] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [PRJ301_Assignment] SET  READ_WRITE
GO
ALTER DATABASE [PRJ301_Assignment] SET RECOVERY SIMPLE
GO
ALTER DATABASE [PRJ301_Assignment] SET  MULTI_USER
GO
ALTER DATABASE [PRJ301_Assignment] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [PRJ301_Assignment] SET DB_CHAINING OFF
GO
USE [PRJ301_Assignment]
GO
/****** Object:  Table [dbo].[Gallery]    Script Date: 07/16/2021 11:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gallery](
	[gid] [int] IDENTITY(1,1) NOT NULL,
	[gimage] [nvarchar](max) NULL,
 CONSTRAINT [PK_Gallery] PRIMARY KEY CLUSTERED 
(
	[gid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Gallery] ON
INSERT [dbo].[Gallery] ([gid], [gimage]) VALUES (1, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-plus-3.jpg')
INSERT [dbo].[Gallery] ([gid], [gimage]) VALUES (2, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-plus-2.jpg')
INSERT [dbo].[Gallery] ([gid], [gimage]) VALUES (3, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-2.jpg')
INSERT [dbo].[Gallery] ([gid], [gimage]) VALUES (4, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-1.jpg')
INSERT [dbo].[Gallery] ([gid], [gimage]) VALUES (5, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-fe-chinh-hang_1.jpg')
INSERT [dbo].[Gallery] ([gid], [gimage]) VALUES (6, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-fe-green-600x600.jpg')
SET IDENTITY_INSERT [dbo].[Gallery] OFF
/****** Object:  Table [dbo].[Category]    Script Date: 07/16/2021 11:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cid] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](150) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON
INSERT [dbo].[Category] ([cid], [name]) VALUES (1, N'Laptops')
INSERT [dbo].[Category] ([cid], [name]) VALUES (2, N'Tablets')
INSERT [dbo].[Category] ([cid], [name]) VALUES (3, N'Hybrids')
SET IDENTITY_INSERT [dbo].[Category] OFF
/****** Object:  Table [dbo].[Blog]    Script Date: 07/16/2021 11:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Blog](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[date] [date] NULL,
	[image] [nvarchar](max) NULL,
 CONSTRAINT [PK_Blog] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Blog] ON
INSERT [dbo].[Blog] ([id], [name], [description], [date], [image]) VALUES (1, N'MacBook Pro - brand new day for business.', N'Organizations everywhere are realizing the potential that Mac brings to their employees by giving them the freedom to use the tools they already know and love. Software and hardware made for each other. Because Apple designs both the software and hardware, every Mac delivers the best possible experience for employees.', CAST(0x1D420B00 AS Date), N'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/macbook-air-og-202011?wid=600&hei=315&fmt=jpeg&qlt=95&.v=1604278672000')
INSERT [dbo].[Blog] ([id], [name], [description], [date], [image]) VALUES (2, N'HP Chromebook review', N'                                    HP Chromebook 11 G4 ($199) has a dull-gray shell that screams, education purchase more than buy Precisely because this school-oriented model can bang around in backpacks, however, it could teach its consumer Chromebook cousins a thing or two about build quality.', CAST(0x1D420B00 AS Date), N'https://www.notebookcheck.net/fileadmin/Notebooks/News/_nc3/HP_ENVY_15_NaturalSilver_Hero_FrontLeft.jpg')
INSERT [dbo].[Blog] ([id], [name], [description], [date], [image]) VALUES (3, N'Apple Music changes, Apple and SUP and more', N'                                    Sunday is Mother''s Day. Wait, did you forget? Well, thanks to Apple, you can make on iPhone Mother''s Day video, using this site.  Upload an image, enter your name, and then you can post the final result so Mom can enjoy.', CAST(0x1D420B00 AS Date), N'https://cdn.mos.cms.futurecdn.net/nCLvAtSHdMfMBHUtmu6TCf.jpg')
INSERT [dbo].[Blog] ([id], [name], [description], [date], [image]) VALUES (4, N'The next generation of Multi-Touch', N'                                    The original iPhone introduced the world to Multi-Touch, forever changing the way people experience technology. With 3D Touch, you can do things that were never possible before. It senses how deeply you press the display, letting you do all kinds of essential things more quickly and simply. And it gives you real-time feedback in the form of subtle taps from the all-new Taptic Engine.', CAST(0x1D420B00 AS Date), N'https://www.ipsos.com/sites/default/files/ct/news_and_polls/2019-10/idea.jpg')
SET IDENTITY_INSERT [dbo].[Blog] OFF
/****** Object:  Table [dbo].[Account]    Script Date: 07/16/2021 11:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[aid] [int] IDENTITY(1,1) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[is_admin] [bit] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[phone] [nvarchar](50) NULL,
	[address] [nvarchar](100) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[aid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON
INSERT [dbo].[Account] ([aid], [email], [password], [is_admin], [name], [phone], [address]) VALUES (1, N'hoang@gmail.com', N'123123', 0, N'Nguyen Huy Hoang', N'0388307592', N'BK')
INSERT [dbo].[Account] ([aid], [email], [password], [is_admin], [name], [phone], [address]) VALUES (4, N'hangxinhbk1@zing.com', N'hoang123', 0, N'Nguyen Huy Hoang', NULL, NULL)
INSERT [dbo].[Account] ([aid], [email], [password], [is_admin], [name], [phone], [address]) VALUES (5, N'abbc@gmail.com', N'hoang123', 0, N'Nguyen Huy Hoang', NULL, NULL)
INSERT [dbo].[Account] ([aid], [email], [password], [is_admin], [name], [phone], [address]) VALUES (6, N'admin@gmail.com', N'admin', 1, N'Admin', NULL, NULL)
INSERT [dbo].[Account] ([aid], [email], [password], [is_admin], [name], [phone], [address]) VALUES (7, N'hoang1@gmail.com', N'123456', 0, N'Nguyen Huy Hoang', N'0388307592', N'viet nam')
SET IDENTITY_INSERT [dbo].[Account] OFF
/****** Object:  Table [dbo].[Product]    Script Date: 07/16/2021 11:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[pid] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](150) NOT NULL,
	[price] [float] NOT NULL,
	[description] [nvarchar](max) NULL,
	[quantity_stock] [int] NOT NULL,
	[cid] [int] NOT NULL,
	[operating_system] [nvarchar](500) NULL,
	[display_resolution] [nvarchar](500) NULL,
	[processor] [nvarchar](500) NULL,
	[processor_technology] [nvarchar](500) NULL,
	[graphics] [nvarchar](500) NULL,
	[memory] [nvarchar](500) NULL,
	[hard_drive] [nvarchar](500) NULL,
	[wireless] [nvarchar](500) NULL,
	[power_supply] [nvarchar](500) NULL,
	[battery] [nvarchar](500) NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[pid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Product] ON
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (1, N'Samsung Galaxy Tab S7 Plus', 799.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 100, 1, N'Windows 10 Pro', N'Screen: 28', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 compatible', N'45 W AC power adapter', N'45 W AC power adapter')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (2, N'Samsung Galaxy Tab S7 ', 699.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 50, 1, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (3, N'iPad Air 10.9 2020 WiFi 64GB', 669.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 200, 1, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (4, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 1, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (7, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 1, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (10, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 2, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (11, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 3, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (12, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 2, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (13, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 2, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (14, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 2, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (15, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 3, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (16, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 1, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (17, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 3, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (18, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 3, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (19, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 3, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (21, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 2, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (22, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 2, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
INSERT [dbo].[Product] ([pid], [name], [price], [description], [quantity_stock], [cid], [operating_system], [display_resolution], [processor], [processor_technology], [graphics], [memory], [hard_drive], [wireless], [power_supply], [battery]) VALUES (23, N'Samsung Galaxy Tab S7 FE', 649.99, N'Visualize ideas as you paint, edit, and design. Let the 10-bit color depth and strikingly large 28 inch display pull you in from across the room. Or, lose yourself in the creative details of your work. Surface Studio is designed with a Zero Gravity Hinge that moves the display weightlessly from an upright angle, down into Studio Mode with one hand.', 20, 2, N'Windows 10 Pro', N'Screen: 28" PixelSense Display', N'Quad-core 6th Gen Intel Core i5 or i7', N'Intel Turbo Boost Technology', N'NVIDIA GeForce GTX 965M 2GB GPU GDDR5 memory or NVIDIA GeForce GTX 980M 4GB GPU GDDR5 memory', N'8GB, 16GB, or 32GB RAM', N'Rapid hybrid drive options: 64GB SSD with 1TB HDD, 128GB SSD with 1TB HDD, 128GB SSD with 2TB HDD', N'Wi-Fi: 802.11ac Wi-Fi wireless networking, IEEE 802.11 a/b/g/n compatible', N'45 W AC power adapter', N'3-cell, 36 Wh Li-ion')
SET IDENTITY_INSERT [dbo].[Product] OFF
/****** Object:  Table [dbo].[Order]    Script Date: 07/16/2021 11:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[oid] [int] IDENTITY(1,1) NOT NULL,
	[date] [date] NULL,
	[aid] [int] NULL,
	[status] [nvarchar](20) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[oid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Order] ON
INSERT [dbo].[Order] ([oid], [date], [aid], [status]) VALUES (1, NULL, 1, N'Canceled')
INSERT [dbo].[Order] ([oid], [date], [aid], [status]) VALUES (2, CAST(0xBF420B00 AS Date), 1, N'Canceled')
INSERT [dbo].[Order] ([oid], [date], [aid], [status]) VALUES (3, CAST(0xBF420B00 AS Date), 1, N'Processing')
INSERT [dbo].[Order] ([oid], [date], [aid], [status]) VALUES (4, CAST(0xC0420B00 AS Date), 1, N'Canceled')
INSERT [dbo].[Order] ([oid], [date], [aid], [status]) VALUES (5, CAST(0xC2420B00 AS Date), 7, N'Pending')
SET IDENTITY_INSERT [dbo].[Order] OFF
/****** Object:  Table [dbo].[Product_Image]    Script Date: 07/16/2021 11:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_Image](
	[pi_id] [int] IDENTITY(1,1) NOT NULL,
	[pimage] [nvarchar](max) NOT NULL,
	[pid] [int] NOT NULL,
 CONSTRAINT [PK_Product_Image] PRIMARY KEY CLUSTERED 
(
	[pi_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Product_Image] ON
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (2, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-plus-2.jpg', 1)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (3, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-2.jpg', 2)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (5, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-1.jpg', 2)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (7, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/i/p/ipad-air-4-xanh.jpg', 3)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (8, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-fe-chinh-hang_1.jpg', 4)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (9, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-fe-green-600x600.jpg', 4)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (14, N'https://cdn.tgdd.vn/Products/Images/522/233257/huawei-t10s-600x600-600x600.jpg', 10)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (19, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-fe-chinh-hang_1.jpg', 11)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (20, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-fe-green-600x600.jpg', 12)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (21, N'https://cdn.tgdd.vn/Products/Images/522/233257/huawei-t10s-600x600-600x600.jpg', 13)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (26, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-fe-chinh-hang_1.jpg', 14)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (27, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-fe-green-600x600.jpg', 15)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (28, N'https://cdn.tgdd.vn/Products/Images/522/233257/huawei-t10s-600x600-600x600.jpg', 17)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (29, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-fe-chinh-hang_1.jpg', 18)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (30, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-fe-green-600x600.jpg', 16)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (32, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-fe-chinh-hang_1.jpg', 19)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (33, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-fe-green-600x600.jpg', 21)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (34, N'https://cdn.tgdd.vn/Products/Images/522/233257/huawei-t10s-600x600-600x600.jpg', 21)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (35, N'https://cdn.tgdd.vn/Products/Images/522/233257/huawei-t10s-600x600-600x600.jpg', 22)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (36, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-fe-chinh-hang_1.jpg', 23)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (37, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-fe-green-600x600.jpg', 23)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (38, N'https://cdn.tgdd.vn/Products/Images/522/233257/huawei-t10s-600x600-600x600.jpg', 21)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (39, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung-galaxy-tab-s7-fe-chinh-hang_1.jpg', 22)
INSERT [dbo].[Product_Image] ([pi_id], [pimage], [pid]) VALUES (41, N'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/1000x/040ec09b1e35df139433887a97daa66f/s/a/samsung-galaxy-tab-s7-fe-green-600x600.jpg', 7)
SET IDENTITY_INSERT [dbo].[Product_Image] OFF
/****** Object:  Table [dbo].[Order_Detail]    Script Date: 07/16/2021 11:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_Detail](
	[oid] [int] NOT NULL,
	[pid] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [float] NOT NULL,
	[total] [float] NOT NULL,
 CONSTRAINT [PK_Order_Detail] PRIMARY KEY CLUSTERED 
(
	[oid] ASC,
	[pid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Order_Detail] ([oid], [pid], [quantity], [price], [total]) VALUES (1, 1, 1, 100, 100)
INSERT [dbo].[Order_Detail] ([oid], [pid], [quantity], [price], [total]) VALUES (2, 2, 1, 699.99, 699.99)
INSERT [dbo].[Order_Detail] ([oid], [pid], [quantity], [price], [total]) VALUES (3, 1, 3, 799.99, 2399.9700000000003)
INSERT [dbo].[Order_Detail] ([oid], [pid], [quantity], [price], [total]) VALUES (3, 3, 1, 669.99, 669.99)
INSERT [dbo].[Order_Detail] ([oid], [pid], [quantity], [price], [total]) VALUES (4, 2, 1, 699.99, 699.99)
INSERT [dbo].[Order_Detail] ([oid], [pid], [quantity], [price], [total]) VALUES (4, 3, 1, 669.99, 669.99)
INSERT [dbo].[Order_Detail] ([oid], [pid], [quantity], [price], [total]) VALUES (5, 3, 3, 669.99, 2009.97)
INSERT [dbo].[Order_Detail] ([oid], [pid], [quantity], [price], [total]) VALUES (5, 4, 1, 649.99, 649.99)
/****** Object:  ForeignKey [FK_Product_Category]    Script Date: 07/16/2021 11:03:42 ******/
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([cid])
REFERENCES [dbo].[Category] ([cid])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
/****** Object:  ForeignKey [FK_Order_Account]    Script Date: 07/16/2021 11:03:42 ******/
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Account] FOREIGN KEY([aid])
REFERENCES [dbo].[Account] ([aid])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Account]
GO
/****** Object:  ForeignKey [FK_Product_Image_Product]    Script Date: 07/16/2021 11:03:42 ******/
ALTER TABLE [dbo].[Product_Image]  WITH CHECK ADD  CONSTRAINT [FK_Product_Image_Product] FOREIGN KEY([pid])
REFERENCES [dbo].[Product] ([pid])
GO
ALTER TABLE [dbo].[Product_Image] CHECK CONSTRAINT [FK_Product_Image_Product]
GO
/****** Object:  ForeignKey [FK_Order_Detail_Order]    Script Date: 07/16/2021 11:03:42 ******/
ALTER TABLE [dbo].[Order_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Order_Detail_Order] FOREIGN KEY([oid])
REFERENCES [dbo].[Order] ([oid])
GO
ALTER TABLE [dbo].[Order_Detail] CHECK CONSTRAINT [FK_Order_Detail_Order]
GO
/****** Object:  ForeignKey [FK_Order_Detail_Product]    Script Date: 07/16/2021 11:03:42 ******/
ALTER TABLE [dbo].[Order_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Order_Detail_Product] FOREIGN KEY([pid])
REFERENCES [dbo].[Product] ([pid])
GO
ALTER TABLE [dbo].[Order_Detail] CHECK CONSTRAINT [FK_Order_Detail_Product]
GO
