import type { ProjectPage } from "./models";
import React from 'react'
import ProtectedRoute from "./RedirectRoutes/ProtectedRoute";
import AuthenticationRoute from "./RedirectRoutes/AuthenticationRoute";

const
    HomePage = React.lazy(() => import('../../pages/home/HomePage')),
    LoginPage = React.lazy(() => import('../../pages/login/LoginPage')),
    RegisterPage = React.lazy(() => import('../../pages/register/RegisterPage'))

export const api_url = (import.meta as any).env.VITE_API_URL;

export const ProjectPages = [
    { label: "Home", name: "Home Page", path: "/", element: <ProtectedRoute><HomePage /></ProtectedRoute> },
    { label: "Home", name: "Home Page", path: "/*", element: <ProtectedRoute><HomePage /></ProtectedRoute> },
    { label: "Login", name: "Home Page", path: "/login", element: <AuthenticationRoute><LoginPage /></AuthenticationRoute> },
    { label: "Register", name: "Home Page", path: "/register", element: <RegisterPage /> },
] as ProjectPage[]