import { NavLink } from "react-router-dom"
import { PageTitle } from "../../components/common/PageTitle"
import { BasePage } from "../../components/layout/BasePage"
import './_home.scss'
import axios from "axios"
import { useState } from "react"
import { api_url } from "../../components/common/ProjectPages"
export default () => {
    const [value, setValue] = useState<string>("");
    const clickButton = async () => {
       var v =  await axios.get(`${api_url}/auth/hello`)
       console.log(v)
       setValue(v.data)
    }
    return <BasePage pageCssClass="home-page">
        <div className="wrapper">
            Home Page
        </div>
        <button onClick={clickButton}>Click me</button>
        <div>{value}</div>
    </BasePage>
}
