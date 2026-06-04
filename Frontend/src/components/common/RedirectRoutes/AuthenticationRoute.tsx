import { Navigate } from "react-router-dom";
import { useAuth } from "../Auth/AuthContext";
import { Loader } from "../Loader";

interface Props {
    children: React.ReactNode;
}

export default function GuestRoute({
    children,
}: Props) {

    const { authenticated, loading } = useAuth();

    if (loading) {
        return <Loader />;
    }

    return authenticated
        ? <Navigate to="/" replace />
        : <>{children}</>;
}