export const PageTitle = (props: { className?: string, children: any }) => {
    const { children, className } = props;
    return <h2 className={["page-title", className].join(" ")}>
        {children}
    </h2>
}