import { useForm, type SubmitHandler } from "react-hook-form"
import { BasePage } from "../../components/layout/BasePage"
import "./_login.scss"
import { NavLink, useNavigate } from "react-router-dom"
import { login } from "../../helpers/authHelpers"
import { setCookie } from "../../helpers/cookieHelper"
import { useAuth } from "../../components/common/Auth/AuthContext"

type LoginInputs = {
    login: string
    password: string
}

export default () => {
    const {
        register,
        handleSubmit,
        watch,
        formState: { errors },
    } = useForm<LoginInputs>(),
        nav = useNavigate(),
        { refreshUser } = useAuth()


    const onSubmit: SubmitHandler<LoginInputs> = async (data) => {
        var res = await login(data)
        if (!res.success)
            return;
        setCookie("authorized", "true", 1)
        refreshUser()
        nav("/")
    }
    return <BasePage pageCssClass="auth-page login-page">
        <div className="wrapper">
            <form onSubmit={handleSubmit(onSubmit)}>
                <input placeholder="email" {...register("login")} />
                <input placeholder="password" {...register("password")} type="password" />

                <input type="submit" value={"Zaloguj"} />
            </form>
            <NavLink to={'/register'}>Register</NavLink>
        </div>
    </BasePage>
}

