package com.brendoreis.carteirinhadigital2devest.app.navigation.professor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.brendoreis.carteirinhadigital2devest.app.navigation.GraphRoutes
import com.brendoreis.carteirinhadigital2devest.app.navigation.ProfileGuard
import com.brendoreis.carteirinhadigital2devest.app.ui.AppShell
import com.brendoreis.carteirinhadigital2devest.feature.login.domain.model.PerfilAcesso
import com.brendoreis.carteirinhadigital2devest.feature.login.domain.model.UsuarioLogado
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.screen.TurmasProfessorScreen
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.presentation.ProfessorUnidadeCurricularViewModel
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.presentation.factory.ProfessorUnidadeCurricularViewModelFactory
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.presentation.screen.ProfessorUnidadesCurricularesScreen
import com.brendoreis.carteirinhadigital2devest.feature.professor.home.presentation.screen.HomeProfessorScreen
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.repository.TurmaRepository
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.TurmaViewModel
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.factory.TurmaViewModelFactory
import kotlinx.coroutines.flow.StateFlow

fun NavGraphBuilder.professorNavGraph(
    navController: NavHostController,
    usuarioLogadoFlow: StateFlow<UsuarioLogado?>,
    turmaRepository: TurmaRepository,
    unidadeCurricularRepository: ProfessorUnidadeCurricularRepository,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit
) {
    navigation(startDestination = ProfessorRoutes.HOME, route = GraphRoutes.PROFESSOR) {
        composable(ProfessorRoutes.HOME) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                AppShell(
                    title = "Início",
                    usuarioLogado = usuario,
                    canNavigateBack = false,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {},
                    onLogout = onLogout
                ) { innerPadding ->
                    HomeProfessorScreen(
                        usuarioLogado = usuario,
                        onTurmasClick = { navController.navigate(ProfessorRoutes.TURMAS) },
                        onUnidadesCurricularesClick = { navController.navigate(ProfessorRoutes.UNIDADES_CURRICULARES) },
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }

        composable(ProfessorRoutes.TURMAS) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                val factory = remember(turmaRepository) { TurmaViewModelFactory(turmaRepository) }
                val turmaViewModel: TurmaViewModel = viewModel(factory = factory)
                AppShell(
                    title = "Minhas Turmas",
                    usuarioLogado = usuario,
                    canNavigateBack = true,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = { navController.popBackStack() },
                    onLogout = onLogout
                ) { innerPadding ->
                    TurmasProfessorScreen(
                        viewModel = turmaViewModel,
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }

        composable(ProfessorRoutes.UNIDADES_CURRICULARES) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                val factory = remember(unidadeCurricularRepository) {
                    ProfessorUnidadeCurricularViewModelFactory(unidadeCurricularRepository)
                }
                val unidadeViewModel: ProfessorUnidadeCurricularViewModel = viewModel(factory = factory)
                AppShell(
                    title = "Unidades Curriculares",
                    usuarioLogado = usuario,
                    canNavigateBack = true,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = { navController.popBackStack() },
                    onLogout = onLogout
                ) { innerPadding ->
                    ProfessorUnidadesCurricularesScreen(
                        viewModel = unidadeViewModel,
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }
    }
}
