import { useForm, type SubmitHandler } from "react-hook-form"
import { BasePage } from "../../components/layout/BasePage"
import "./_login.scss"
import { NavLink } from "react-router-dom"

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
    } = useForm<LoginInputs>()
    const onSubmit: SubmitHandler<LoginInputs> = (data) => console.log(data)


    return <BasePage pageCssClass="auth-page login-page">
        <div className="wrapper">
            <form onSubmit={handleSubmit(onSubmit)}>
                <input {...register("login")} />
                <input {...register("password")} type="password" />

                <input type="submit" value={"Zaloguj"} />
            </form>
            <NavLink to={'/register'}>Register</NavLink>
        </div>
    </BasePage>
}

