const showOneUser = async () => {
    try {
        const response = await fetch("http://localhost:8080/api/user/showOnlyUser");
        if (!response.ok) {
            throw new Error("Error retrieving user data.");
        }
        const user = await response.json();
        console.log(user);

        const tableRow = document.createElement("tr");
        tableRow.innerHTML = `
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${user.lastName}</td>
      <td>${user.age}</td>
      <td>${user.email}</td>
      <td>${user.roles.map(role => role.roleType.substring(5)).join(", ")}</td>
    `;

        document.getElementById("oneUserBody").appendChild(tableRow);
    } catch (error) {
        console.error(error);
    }
};

showOneUser();