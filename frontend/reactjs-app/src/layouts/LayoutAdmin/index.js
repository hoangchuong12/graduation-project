import React, { createContext, useState, useEffect, useContext } from 'react';
import { Outlet, useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import './layoutAdmin.css';
import { FaProductHunt, FaClone, FaRegUser } from "react-icons/fa";
import { MdExitToApp, MdContactSupport } from "react-icons/md";
import { RiArticleFill } from "react-icons/ri";
import { SiSellfy } from "react-icons/si";
import { BiSolidUserRectangle } from "react-icons/bi";
import { BsDisplay } from "react-icons/bs";
import { GrSystem } from "react-icons/gr";
import { toast, ToastContainer } from 'react-toastify';
import UserService from '../../services/UserService';
import LoginAdmin from './LoginAdmin';

const AdminContext = createContext();

export const useAdminContext = () => useContext(AdminContext);

const LayoutAdmin = () => {
    const [user, setUser] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const storedUserAdmin = sessionStorage.getItem('useradmin');
        if (storedUserAdmin !== null) {
            console.log("token : ", storedUserAdmin);
            try {
                const parsedUser = JSON.parse(storedUserAdmin);
                if (parsedUser && typeof parsedUser === 'object') {
                    setUser(parsedUser);
                    // Lấy thông tin người dùng từ server bằng cách gọi hàm UserService.getUser
                    UserService.getUser(parsedUser.userId)
                        .then(userGet => {
                            console.log("user : ", userGet);
                            // Xử lý dữ liệu user ở đây (nếu cần)
                        })
                        .catch(error => {
                            console.error('Error fetching user:', error);
                        });
                    UserService.getProduct()
                        .then(productGet => {
                            console.log("product : ", productGet);
                            // Xử lý dữ liệu user ở đây (nếu cần)
                        })
                        .catch(error => {
                            console.error('Error fetching user:', error);
                        });
                } else {
                    console.error('Stored user is not a valid JSON object.');
                }
            } catch (error) {
                console.error('Error parsing stored user:', error);
            }
        }
    }, []);



    const login = async (authRequest) => {
        try {
            const response = await UserService.loginAdmin(authRequest);
            if (response) {
                console.log(response);

                // Lưu thông tin người dùng vào Session Storage thay vì Local Storage
                const { userId, token } = response;
                const userData = { userId, token };
                sessionStorage.setItem('useradmin', JSON.stringify(userData)); // Thay đổi từ localStorage sang sessionStorage

                setUser(response); // Đặt thông tin người dùng vào state
                toast.success('Đăng nhập thành công');
                navigate("/admin");
            } else {
                toast.error("Đăng nhập thất bại!");
            }
        } catch (error) {
            console.log('Login error');
            toast.error('Đăng nhập thất bại!');
        }
    };

    const logout = () => {
        sessionStorage.removeItem('useradmin'); // Xóa thông tin người dùng từ Session Storage
        setUser(null);
        navigate("/admin/login");
    };


    function handleItemClick(item) {
        const hdlitem = document.getElementById(item);
        hdlitem.classList.toggle("active");
    };

    return (
        <>
            <ToastContainer />
            <AdminContext.Provider value={{ user, login, logout }}>
                {user === null ? (
                    <LoginAdmin login={login} />
                ) : (
                    <>
                        <section className="hdl-header sticky-top">
                            <div className="container-fluid">
                                <ul className="menutop">
                                    <li>
                                        <a href="#nqt">
                                            <FaClone />
                                            E COMMERCE
                                        </a>
                                    </li>
                                    <li className="text-phai">
                                        <a href="#nqt" onClick={logout}>
                                            <MdExitToApp />
                                            Thoát
                                        </a>
                                    </li>
                                    <li className="text-phai">
                                        <a href="#nqt">
                                            <FaRegUser />
                                            Chào quản lý
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </section>
                        <section className="hdl-content">
                            <div className="container-fluid">
                                <div className="row">
                                    <div className="col-md-2 bg-dark p-0 hdl-left">
                                        <div className="hdl-left">
                                            <div className="dashboard-name">
                                                Bản điều khiển
                                            </div>
                                            <nav className="m-2 mainmenu">
                                                <ul className="main">
                                                    <li className="hdlitem item-sub" id="item1" onClick={() => handleItemClick('item1')}>
                                                        <FaProductHunt className="icon-left" />
                                                        <a href="#nqt">Sản phẩm</a>
                                                        <i className="fa-solid fa-plus icon-right"></i>
                                                        <ul className="submenu">
                                                            <li>
                                                                <a href="/admin/product/index" className="margin-left-submenu">Tất cả sản phẩm</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/product/import" className="margin-left-submenu">Nhập hàng</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/category/index" className="margin-left-submenu">Danh mục</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/brand/index" className="margin-left-submenu">Thương hiệu</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/product/sale" className="margin-left-submenu">Khuyễn mãi</a>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li className="hdlitem item-sub" id="item2" onClick={() => handleItemClick('item2')}>
                                                        <RiArticleFill className="icon-left" />
                                                        <a href="#nqt">Bài viết</a>
                                                        <i className="fa-solid fa-plus icon-right"></i>
                                                        <ul className="submenu">
                                                            <li>
                                                                <a href="/admin/post/index">Tất cả bài viết</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/topic/index">Chủ đề</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/page/index">Trang đơn</a>
                                                            </li>
                                                        </ul>
                                                    </li>

                                                    <li className="hdlitem item-sub" id="item3" onClick={() => handleItemClick('item3')}>
                                                        <SiSellfy className="icon-left" />
                                                        {/* <i className="fa-brands fa-product-hunt icon-left"></i> */}
                                                        <a href="#nqt">Quản lý bán hàng</a>
                                                        <i className="fa-solid fa-plus icon-right"></i>
                                                        <ul className="submenu">
                                                            <li>
                                                                <a href="/admin/order/index">Tất cả đơn hàng</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/order/export">Xuất hàng</a>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li className="hdlitem">
                                                        <BiSolidUserRectangle className="icon-left" />
                                                        {/* <i className="fa-regular fa-circle icon-left"></i> */}
                                                        <a href="/admin/user/index">Khách hàng</a>
                                                    </li>
                                                    <li className="hdlitem">
                                                        <MdContactSupport className="icon-left" />
                                                        {/* <i className="fa-regular fa-circle icon-left"></i> */}
                                                        <a href="/admin/contact/index">Liên hệ</a>
                                                    </li>
                                                    <li className="hdlitem item-sub" id={'item4'} onClick={() => handleItemClick('item4')}>
                                                        <BsDisplay className="icon-left" />
                                                        {/* <i className="fa-brands fa-product-hunt icon-left"></i> */}
                                                        <a href="#nqt">Giao diện</a>
                                                        <i className="fa-solid fa-plus icon-right"></i>
                                                        <ul className="submenu">
                                                            <li>
                                                                <a href="/admin/menu/index">Menu</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/banner/index">Banner</a>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li className="hdlitem item-sub" id="item5" onClick={() => handleItemClick('item5')}>
                                                        <GrSystem className="icon-left" />
                                                        {/* <i className="fa-brands fa-product-hunt icon-left"></i> */}
                                                        <a href="#nqt">Hệ thống</a>
                                                        <i className="fa-solid fa-plus icon-right"></i>
                                                        <ul className="submenu">
                                                            <li>
                                                                <a href="/admin/staff/index">Thành viên</a>
                                                            </li>
                                                            <li>
                                                                <a href="/admin/config/index">Cấu hình</a>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                    <div className="col-md-10">
                                        <div className="content">
                                            <Outlet />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </>
                )}

            </AdminContext.Provider>
        </>
    );

};
export default LayoutAdmin;