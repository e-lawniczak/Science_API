import { Suspense } from 'react';
import { ProjectPages } from './components/common/ProjectPages';
import './styles/appStyles.scss'
import {
  createBrowserRouter,
  RouterProvider,

} from "react-router-dom";
import { Loader } from './components/common/Loader';
import AuthProvider from './components/common/Auth/AuthProvider';



const App = () => {

  const router = createBrowserRouter(
    ProjectPages.map(p => {
      return {
        path: p.path,
        element: <Suspense fallback={<Loader />}>
          {p.element}
        </Suspense>
      }
    })
  )
  return (
    <div className='app-container'>
      <AuthProvider>
        <RouterProvider router={router} />
      </AuthProvider>
    </div>
  )
}

export default App
