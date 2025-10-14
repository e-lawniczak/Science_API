import { useState, useEffect } from "react"
import { Footer } from "./Footer"
import { Header } from "./Header"
import { SideBar } from "./SideBar"

export const BasePage = (props: { children: any, pageCssClass: string, [x: string]: any }) => {
    const
        { children, pageCssClass } = props
    const [_, setMode] = useState('light')
    const onSelectMode = (mode: string) => {
        setMode(mode)
        if (mode === 'dark')
            document.body.classList.toggle('dark-mode')
        else if (mode === 'light')
            document.body.classList.toggle('light-mode')

    }
    useEffect(() => {
        window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', e => onSelectMode(e.matches ? 'dark' : 'light'));

        onSelectMode(window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light')

        return () => {
            window.matchMedia('(prefers-color-scheme: dark)').removeEventListener('change', () => {
            });
        }
    }, []);

    return <div className={["page", pageCssClass].join(" ")}>
        <div className="page-content">
            <Header />
            <div className="content">
                {children}
            </div>
            <Footer />
        </div>
    </div>
}