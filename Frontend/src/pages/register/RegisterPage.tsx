import { useForm, type SubmitHandler } from "react-hook-form"
import { BasePage } from "../../components/layout/BasePage"

type RegisterInputs = {
    login: string
    email: string
    password: string
    repeatPassword: string
}

export default () => {
    const {
        register,
        handleSubmit,
        watch,
        formState: { errors },
    } = useForm<RegisterInputs>()
    const onSubmit: SubmitHandler<RegisterInputs> = (data) => console.log(data)


    return <BasePage pageCssClass="auth-page login-page">
        <div className="wrapper">
            <form onSubmit={handleSubmit(onSubmit)}>
                <input {...register("login")} />
                <input {...register("email")} type="email" />
                <input {...register("password")} type="password" />
                <input {...register("repeatPassword")} type="password" />

                <input type="submit" value={"Zaloguj"} />
            </form>
        </div>
    </BasePage>
}

