import { useAuth } from "../common/Auth/AuthContext"

export const Footer = () => {

    const
        {user} = useAuth()

    return <footer className={["site-footer"].join(" ")}>
        <div className="wrapper">
            copyright {user?.email}
        </div>
    </footer>
}