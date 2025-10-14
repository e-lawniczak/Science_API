import { NavLink } from "react-router-dom"
import { PageTitle } from "../../components/common/PageTitle"
import { BasePage } from "../../components/layout/BasePage"
import './_home.scss'
export default () => {
    return <BasePage pageCssClass="home-page">
        <div className="wrapper">
           Home Page
        </div>
    </BasePage>
}
