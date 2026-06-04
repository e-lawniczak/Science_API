import { useForm, type SubmitHandler } from "react-hook-form"
import { BasePage } from "../../components/layout/BasePage"
import axios from "axios"
import { api_url } from "../../components/common/ProjectPages"
import { registerUser } from "../../helpers/authHelpers"

type RegisterInputs = {
    firstName: string
    lastName: string
    email: string
    password: string
    repeatPassword: string
    phone: string
}

export default () => {
    const {
        register,
        handleSubmit,
        watch,
        formState: { errors },
    } = useForm<RegisterInputs>()
    const onSubmit: SubmitHandler<RegisterInputs> = async (data) => {
        var res = await registerUser()
    }


    return <BasePage pageCssClass="auth-page login-page">
        <div className="wrapper">
            <form onSubmit={handleSubmit(onSubmit)}>
                <input placeholder="firstName" {...register("firstName")} />
                <input placeholder="lastName" {...register("lastName")} />
                <input placeholder="email" {...register("email")} type="email" />
                <input placeholder="password" {...register("password")} type="password" />
                <input placeholder="repeatPassword" {...register("repeatPassword")} type="password" />
                <input placeholder="phone" {...register("phone")} type="text" />

                <input type="submit" value={"Zarejestruj"} />
            </form>
        </div>
    </BasePage>
}

