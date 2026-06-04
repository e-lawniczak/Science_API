import type { ProjectPage } from "./models";
import React from 'react'
import ProtectedRoute from "./RedirectRoutes/ProtectedRoute";
import AuthenticationRoute from "./RedirectRoutes/AuthenticationRoute";

const
    HomePage = React.lazy(() => import('../../pages/home/HomePage')),
    DisorderPage = React.lazy(() => import('../../pages/disorder/DisorderPage')),
    LoginPage = React.lazy(() => import('../../pages/login/LoginPage')),
    RegisterPage = React.lazy(() => import('../../pages/register/RegisterPage'))

export const api_url = (import.meta as any).env.VITE_API_URL;

export const ProjectPages = [
    { label: "Home", name: "Home Page", path: "/", element: <ProtectedRoute><HomePage /></ProtectedRoute>, isAuth: true, isMenuElement: true },
    { label: "Disorder", name: "Add disorder", path: "/disorder", element: <ProtectedRoute><DisorderPage /></ProtectedRoute>, isAuth: true, isMenuElement: true },
    { label: "Home", name: "Home Page", path: "/*", element: <ProtectedRoute><HomePage /></ProtectedRoute>, isAuth: true, isMenuElement: false },
    { label: "Login", name: "Home Page", path: "/login", element: <AuthenticationRoute><LoginPage /></AuthenticationRoute>, isAuth: false, isMenuElement: true },
    { label: "Register", name: "Home Page", path: "/register", element: <AuthenticationRoute><RegisterPage /></AuthenticationRoute>, isAuth: false, isMenuElement: true },
] as ProjectPage[]