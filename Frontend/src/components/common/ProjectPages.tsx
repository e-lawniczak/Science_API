import type { ProjectPage } from "./models";
import React from 'react'

const
    HomePage = React.lazy(() => import('../../pages/home/HomePage')),
    LoginPage = React.lazy(() => import('../../pages/login/LoginPage')),
    RegisterPage = React.lazy(() => import('../../pages/register/RegisterPage'))

export const api_url = (import.meta as any).env.VITE_API_URL;

export const ProjectPages = [
    { label: "Home", name: "Home Page", path: "/", element: <HomePage /> },
    { label: "Home", name: "Home Page", path: "/*", element: <HomePage /> },
    { label: "Login", name: "Home Page", path: "/login", element: <LoginPage /> },
    { label: "Register", name: "Home Page", path: "/register", element: <RegisterPage /> },
] as ProjectPage[]