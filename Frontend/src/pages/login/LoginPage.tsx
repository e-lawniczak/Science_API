import { useForm, type SubmitHandler } from "react-hook-form"
import { BasePage } from "../../components/layout/BasePage"
import "./_login.scss"
import { NavLink } from "react-router-dom"
import { api_url } from "../../components/common/ProjectPages"
import axios from "axios"

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
  
      const onSubmit: SubmitHandler<LoginInputs> = async (data) => {
          var res = await axios.post(`${api_url}/auth/login`, data)
          console.log(res);
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

