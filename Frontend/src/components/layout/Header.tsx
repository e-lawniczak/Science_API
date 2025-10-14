import '../../styles/_header.scss'
import { useEffect, useState } from "react"
import { ProfileInfo } from './SideBar'
import { NavLink } from 'react-router-dom'

export const Header = () => {


    return <header className={["site-header"].join(" ")}>
        <div className="wrapper">
          <NavLink to={'/login'} >Login</NavLink>
        </div>
    </header>
}

export const SocialLinks = (props: { className?: string }) => {
    const [mode, setMode] = useState('light')
    const onSelectMode = (mode: string) => {
        setMode(mode)

    }
    useEffect(() => {
        window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', e => onSelectMode(e.matches ? 'dark' : 'light'));
        onSelectMode(window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light')
        return () => {
            window.matchMedia('(prefers-color-scheme: dark)').removeEventListener('change', () => {
            });
        }
    }, []);
    return <div className={["social-links", props.className].join(" ")}>
        <a target="blank" href="https://www.linkedin.com/in/eryk-lawniczak" className={`social-link ${mode}-mode linked-in`}></a>
        <a target="blank" href="https://github.com/e-lawniczak" className={`social-link ${mode}-mode git`}></a>
        <a target="blank" href="mailto:eryk.lawniczak@gmail.com" className={`social-link ${mode}-mode email`}></a>
    </div>
}