import { NavLink } from "react-router-dom"
import '../../styles/_sideBar.scss'
import { ProjectPages } from "../common/ProjectPages"
import { useState } from "react"
export const SideBar = () => {
    const [menuShow, setMenuShow] = useState(false);
    const menuElements = ProjectPages.map((p, idx) => p.path != '/*' && <NavLink key={idx.toString() + p.label} to={p.path} className={'opt'} >{p.label}</NavLink>).filter(p => p)

    return <>
        <div onClick={() => setMenuShow(!menuShow)} className="mobile-menu mobile">
            <div className="line"></div>
            <div className="line"></div>
            <div className="line"></div>
        </div>
        <nav className={["side-bar", menuShow ? "menu-active" : ""].join(" ")}>
            <div className="navigation">
                {menuElements}
            </div>
        </nav>
    </>
}
export const ProfileInfo = (props: { className?: string }) => {

    return <div className={["profile-text", props.className].join(" ")}>
        <NavLink to={"/"}>
            <h1>
                Eryk Ławniczak
            </h1>
            <h4>Software Developer</h4>
            <h4>Poznań, Poland</h4>
        </NavLink>
        <a className="mail-link" href="mailto:eryk.lawniczak@gmail.com">eryk.lawniczak@gmail.com</a>
    </div>
}