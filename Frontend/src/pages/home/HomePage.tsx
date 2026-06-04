import { BasePage } from "../../components/layout/BasePage"
import './_home.scss'
import { useState } from "react"
import { APIClient } from "../../helpers/APIClient"
import { API_ROUTES } from "../../components/common/API_ROUTES"

export default () => {
    const [value, setValue] = useState<any>(null);
    const clickButton = async () => {
        var v = new APIClient();
        var res = await v.get(API_ROUTES.me)
        setValue(res.data)
    }
    return <BasePage pageCssClass="home-page">
        <div className="wrapper">
            Home Page
        </div>
        <button onClick={clickButton}>Click me</button>
        <div>{value?.email}</div>
    </BasePage>
}
